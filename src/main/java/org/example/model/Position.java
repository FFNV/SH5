package org.example.model;

public class Position {
    private String title;
    private Salary salary;

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

    @Override
    public String toString() {
        return "Должность { " +
                "Название: '" + title + '\'' +
                ", Зарплата: " + salary +
                " }";
    }
}
