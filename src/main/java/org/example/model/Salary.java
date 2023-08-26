package org.example.model;

public class Salary {
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Зарплата { " +
                "Сумма: " + amount +
                " }";
    }
}
