package org.example;

import org.example.service.SalaryService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SalaryMutatorBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SalaryService) {

            SalaryService salaryService = (SalaryService) bean;
            mutateSalary(salaryService);
        }
        return bean;
    }

    private void mutateSalary(SalaryService salaryService) {

        double newSalary = salaryService.getSalary().getAmount() + 1000.0;
        salaryService.getSalary().setAmount(newSalary);
    }
}
