package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.MathSalaryCalculator;
import org.example.model.Position;
import org.example.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SalaryService {

    private static final Logger logger = LogManager.getLogger(SalaryService.class);

    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    private Salary salary;

    @Autowired
    private MathSalaryCalculator mathSalaryCalculator;


    public void bindSalaryToPosition(Position position, Salary salary, Double inflation, Double exchangeRate) {
        if (position == null || salary == null || inflation == null || exchangeRate == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null");
        }

        if (inflation < 0 || exchangeRate <= 0) {
            throw new IllegalArgumentException("Инфляция не может быть отрицательной, а обменный курс не может быть нулевым или отрицательным");
        }

        // Calculate salary with Math power
        double editedSalary = salary.getAmount() * Math.pow((1 + inflation), 2) * exchangeRate;
        double finalSalary = mathSalaryCalculator.calculateSalaryWithMathPower(editedSalary, 2.0);

        salary.setAmount(editedSalary);
        position.setSalary(salary);

        String message = "Заработная плата: " + editedSalary + " на должность: " + position.getTitle();
        System.out.println(message);
        logger.info(message);
    }


    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}

