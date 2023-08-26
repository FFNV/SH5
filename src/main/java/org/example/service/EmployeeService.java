package org.example.service;

import org.example.model.Employee;
import org.example.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("someQualifier")
public class EmployeeService {

    private static final Logger logger = LogManager.getLogger(EmployeeService.class);

    @Autowired
    private PositionService positionService;

    public EmployeeService(PositionService positionService) {

    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    private final List<Employee> employees = new ArrayList<>();

    public void hireEmployee(Employee employee, Position position) {
        if (employee == null || position == null) {
            throw new IllegalArgumentException("Сотрудник и должность не могут быть равны null");
        }

        if (employee.getPosition() != null) {
            throw new IllegalStateException("Сотрудник уже имеет должность");
        }

        employee.setPosition(position);
        employees.add(employee);
        String message = "Нанят работник: " + employee.getName() + " на должность: " + position.getTitle();
        System.out.println(message);
        logger.info(message);
    }

    public void fireEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Сотрудник не может быть null");
        }

        if (employee.getPosition() == null) {
            throw new IllegalStateException("У сотрудника нет должности");
        }

        employee.setPosition(null);
        employees.remove(employee);
        String message = "Уволен сотрудник: " + employee.getName();
        System.out.println(message);
        logger.info(message);
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }
}

