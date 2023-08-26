package org.example.service;

import org.example.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope("singleton")
public class PositionService {

    private static final Logger logger = LogManager.getLogger(PositionService.class);

    private SalaryService salaryService;

    @Autowired
    public void setSalaryService(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    private final List<Position> positions = new ArrayList<>();

    public void createPosition(Position position) {
        if (position == null || positions.contains(position)) {
            throw new IllegalArgumentException("Позиция не должна быть null и должна быть уникальной");
        }

        positions.add(position);
        String message = "Созданная должность: " + position.getTitle();
        System.out.println(message);
        logger.info(message);
    }

    public void updatePosition(Position position) {
        if (position == null || !positions.contains(position)) {
            throw new IllegalArgumentException("Позиция не должна быть равна null и должна существовать");
        }

        int index = positions.indexOf(position);
        positions.set(index, position);
        String message = "Обновленная должность: " + position.getTitle();
        System.out.println(message);
        logger.info(message);
    }

    public void deletePosition(Position position) {
        if (position == null || !positions.contains(position)) {
            throw new IllegalArgumentException("Позиция не должна быть равна null и должна существовать");
        }

        positions.remove(position);
        String message = "Удаленная должность: " + position.getTitle();
        System.out.println(message);
        logger.info(message);
    }

    public List<Position> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}

