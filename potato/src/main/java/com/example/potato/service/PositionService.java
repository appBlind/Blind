package com.example.potato.service;

import com.example.potato.model.Position;
import com.example.potato.repository.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    private final PositionRepo positionRepo;

    @Autowired
    public PositionService(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    public Position savePosition(Position position) {
        return positionRepo.save(position);
    }

    public List<Position> getAllPositions() {
        return positionRepo.findAll();
    }

    public Optional<Position> getPositionById(Long positionId) {
        return positionRepo.findById(positionId);
    }

    public void deletePosition(Long positionId) {
        positionRepo.deleteById(positionId);
    }

}
