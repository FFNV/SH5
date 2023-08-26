package org.example.config;

import org.example.LifecycleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifecycleBean lifecycleBean() {
        return new LifecycleBean();
    }
}
