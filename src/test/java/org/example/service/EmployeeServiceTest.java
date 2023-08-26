package org.example.service;

import org.example.model.Employee;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private PositionService mockPositionService;

    @BeforeEach
    public void setup() {

        mockPositionService = new PositionService();
        employeeService = new EmployeeService(mockPositionService);
    }

    @Test
    public void testHireEmployee() {
        Employee e = new Employee();
        e.setName("Джонни");
        Position p = new Position();
        p.setTitle("Инженер");

        assertNull(e.getPosition());

        employeeService.hireEmployee(e, p);

        assertNotNull(e.getPosition());
        assertEquals("Инженер", e.getPosition().getTitle());
    }

    @Test
    public void testFireEmployee() {
        Employee e = new Employee();
        e.setName("Алиса");
        Position p = new Position();
        p.setTitle("Менеджер");

        employeeService.hireEmployee(e, p);

        assertNotNull(e.getPosition());

        employeeService.fireEmployee(e);

        assertNull(e.getPosition());
    }

    @Test
    public void testGetEmployees() {
        Employee e1 = new Employee();
        e1.setName("Алиса");
        Position p1 = new Position();
        p1.setTitle("Разработчик");

        Employee e2 = new Employee();
        e2.setName("Боб");
        Position p2 = new Position();
        p2.setTitle("Тестировщик");

        employeeService.hireEmployee(e1, p1);
        employeeService.hireEmployee(e2, p2);

        List<Employee> employees = employeeService.getEmployees();

        assertEquals(2, employees.size());
        assertEquals("Алиса", employees.get(0).getName());
        assertEquals("Боб", employees.get(1).getName());
    }

    @Test
    public void testHireEmployeeWithNulls() {
        assertThrows(IllegalArgumentException.class, () -> employeeService.hireEmployee(null, null));
    }

    @Test
    public void testFireEmployeeWithNulls() {
        assertThrows(IllegalArgumentException.class, () -> employeeService.fireEmployee(null));
    }

    @Test
    public void testFireEmployeeWithoutPosition() {
        Employee e = new Employee();
        e.setName("Катя");
        assertThrows(IllegalStateException.class, () -> employeeService.fireEmployee(e));
    }
}
