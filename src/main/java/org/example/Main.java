package org.example;

import org.example.config.AppConfiguration;
import org.example.model.Employee;
import org.example.model.Position;
import org.example.model.Salary;
import org.example.service.EmployeeService;
import org.example.service.PositionService;
import org.example.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
        PositionService positionService = context.getBean(PositionService.class);
        SalaryService salaryService = context.getBean(SalaryService.class);

        // Создание должностей
        Position developer = new Position();
        developer.setTitle("Разработчик");

        Position manager = new Position();
        manager.setTitle("Менеджер");

        positionService.createPosition(developer);
        positionService.createPosition(manager);

        // Создание заработной платы
        Salary devSalary = new Salary();
        devSalary.setAmount(100000.0);

        Salary mgrSalary = new Salary();
        mgrSalary.setAmount(150000.0);

        // Привязка окладов к должностям
        salaryService.bindSalaryToPosition(developer, devSalary, 0.03, 1.0);
        salaryService.bindSalaryToPosition(manager, mgrSalary, 0.05, 1.0);

        // Наем сотрудников
        Employee alice = new Employee();
        alice.setName("Алиса");

        Employee bob = new Employee();
        bob.setName("Боб");

        employeeService.hireEmployee(alice, developer);
        employeeService.hireEmployee(bob, manager);

        // Simulate year 1
        System.out.println("Year 1 simulation...");
        salaryService.bindSalaryToPosition(developer, devSalary, 0.02, 1.1);
        salaryService.bindSalaryToPosition(manager, mgrSalary, 0.04, 1.1);

        // Увольнение сотрудника
        employeeService.fireEmployee(bob);

        // Simulate year 2
        System.out.println("Year 2 simulation...");
        salaryService.bindSalaryToPosition(developer, devSalary, 0.03, 1.2);
        salaryService.bindSalaryToPosition(manager, mgrSalary, 0.02, 1.2);

    }
}
