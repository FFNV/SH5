package org.example.service;

import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionServiceTest {

    private PositionService positionService;

    @BeforeEach
    public void setup() {
        positionService = new PositionService();

    }

    @Test
    public void testCreatePosition() {
        Position position = new Position();
        position.setTitle("Developer");

        positionService.createPosition(position);

        assertTrue(positionService.getPositions().contains(position), "Позиция добавлена некорректно");
    }

    @Test
    public void testUpdatePosition() {
        Position position = new Position();
        position.setTitle("Developer");

        positionService.createPosition(position);

        position.setTitle("Senior Developer");
        positionService.updatePosition(position);

        assertTrue(positionService.getPositions().contains(position), "Позиция обновлена некорректно");
        assertEquals("Senior Developer", position.getTitle(), "Название должности обновляется некорректно");
    }

    @Test
    public void testDeletePosition() {
        Position position = new Position();
        position.setTitle("Developer");

        positionService.createPosition(position);
        positionService.deletePosition(position);

        assertFalse(positionService.getPositions().contains(position), "Позиция удалена некорректно");
    }

}
