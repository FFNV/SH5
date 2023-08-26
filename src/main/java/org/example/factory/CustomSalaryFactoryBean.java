package org.example.factory;

import org.example.model.Salary;
import org.springframework.beans.factory.FactoryBean;

public class CustomSalaryFactoryBean implements FactoryBean<Salary> {

    @Override
    public Salary getObject() throws Exception {
        Salary salary = new Salary();
        salary.setAmount(50000.0); // Сумма по умолчанию
        return salary;
    }

    @Override
    public Class<?> getObjectType() {
        return Salary.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
