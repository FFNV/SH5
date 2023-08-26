package org.example.config;

import org.example.LifecycleBean;
import org.example.factory.CustomSalaryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
@Import({ModelConfiguration.class, ServiceConfiguration.class, LifecycleConfiguration.class})
@ComponentScan (basePackages = {"org.example"})
public class AppConfiguration {

    @Bean
    public CustomSalaryFactoryBean customSalaryFactoryBean() {
        return new CustomSalaryFactoryBean();
    }

    // Bean для поддержки placeholder and SpEL
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // Пример поддержки пользовательского синтаксического анализатора SpEL
    @Bean
    public ExpressionParser expressionParser() {
        return new SpelExpressionParser();
    }

    // Пример LifecycleBean
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifecycleBean lifecycleBean() {
        return new LifecycleBean();
    }
}

