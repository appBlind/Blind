package com.example.potato.controller;


import com.example.potato.model.Position;
import com.example.potato.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        Position savePosition = positionService.savePosition(position);
        return ResponseEntity.ok(savePosition);
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<Position> getPositionById(@PathVariable Long positionId) {
        Optional<Position> position = positionService.getPositionById(positionId);
        return position.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{positionId}")
    public ResponseEntity<Void> deletePosition(@PathVariable Long positionId) {
        positionService.deletePosition(positionId);
        return ResponseEntity.noContent().build();
    }
}
