package org.example.model;

import java.util.List;

public class Position {
    private String title;
    private Salary salary;
    private List<Skill> requiredSkills;

    public Position() {
    }

    public Position(String title, Salary salary, List<Skill> requiredSkills) {
        this.title = title;
        this.salary = salary;
        this.requiredSkills = requiredSkills;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }
    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    @Override
    public String toString() {
        return "Должность { " +
                "Название: '" + title + '\'' +
                ", Зарплата: " + salary +
                " }";
    }
}
