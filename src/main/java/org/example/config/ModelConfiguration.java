package org.example.config;

import org.example.model.Employee;
import org.example.model.Position;
import org.example.model.Salary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration {

    @Bean
    public Employee employee() {
        return new Employee();
    }

    @Bean
    public Position position() {
        return new Position();
    }

    @Bean
    public Salary salary() {
        return new Salary();
    }
}

