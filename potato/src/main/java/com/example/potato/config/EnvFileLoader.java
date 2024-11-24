package com.example.potato.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EnvFileLoader implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource resource = new FileSystemResource(".env/local");
        if (resource.exists()) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(".env/local"));
                for (String line : lines) {
                    if (!line.startsWith("#") && line.contains("=")) {
                        String[] keyValue = line.split("=", 2);
                        String key = keyValue[0].trim();
                        String value = keyValue[1].trim().replace("\"", "");
                        System.setProperty(key, value);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to load .env/local file", e);
            }
        }
    }
}