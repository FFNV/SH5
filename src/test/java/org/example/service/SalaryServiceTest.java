package org.example.service;

import org.example.model.Position;
import org.example.model.Salary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryServiceTest {

    private SalaryService salaryService;

    @BeforeEach
    void setUp() {
        salaryService = new SalaryService();

    }

    @Test
    void testBindSalaryToPosition() {
        Position position = new Position();
        position.setTitle("Разработчик");

        Salary salary = new Salary();
        salary.setAmount(1000.0);

        salaryService.bindSalaryToPosition(position, salary, 0.1, 1.5);

        assertNotNull(position.getSalary(), "Заработная плата не соответствует занимаемой должности");
        assertEquals(1650.0, position.getSalary().getAmount(), "Сумма заработной платы рассчитана неверно");
    }

    @Test
    void testBindSalaryToPositionWithNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> salaryService.bindSalaryToPosition(null, null, null, null));
    }

    @Test
    void testBindSalaryToPositionWithNegativeInflation() {
        Position position = new Position();
        Salary salary = new Salary();

        assertThrows(IllegalArgumentException.class, () -> salaryService.bindSalaryToPosition(position, salary, -1.0, 1.0));
    }

    @Test
    void testBindSalaryToPositionWithZeroExchangeRate() {
        Position position = new Position();
        Salary salary = new Salary();

        assertThrows(IllegalArgumentException.class, () -> salaryService.bindSalaryToPosition(position, salary, 0.1, 0.0));
    }

}

