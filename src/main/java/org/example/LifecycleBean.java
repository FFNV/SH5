package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleBean {

    private static final Logger logger = LoggerFactory.getLogger(LifecycleBean.class);

    public void init() {
        logger.info("LifecycleBean is initialized.");
        System.out.println("LifecycleBean инициализирован.");
    }

    public void destroy() {
        logger.info("LifecycleBean is destroyed.");
        System.out.println("LifecycleBean уничтожен.");
    }
}

