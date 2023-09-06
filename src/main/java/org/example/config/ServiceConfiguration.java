package org.example.config;

import org.example.MathSalaryCalculator;
import org.example.model.Salary;
import org.example.service.EmployeeService;
import org.example.service.PositionService;
import org.example.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ServiceConfiguration {

    @Autowired
    private PositionService positionService;

    @Bean(name = "employeeService")
    @Scope("singleton")
    public EmployeeService employeeService() {
        return new EmployeeService(positionService);
    }

    @Bean
    public PositionService positionService() {
        return new PositionService();
    }

    @Bean
    @Scope("prototype")
    public SalaryService salaryService() {
        SalaryService salaryService = new SalaryService();
        // Create and set the Salary object with a non-null value
        Salary salary = new Salary();
        salary.setAmount(50000.0); // Set an initial value
        salaryService.setSalary(salary);
        return salaryService;
    }

    @Bean
    public MathSalaryCalculator mathSalaryCalculator() {
        return new MathSalaryCalculator();
    }

}
