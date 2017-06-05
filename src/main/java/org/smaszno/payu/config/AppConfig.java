package org.smaszno.payu.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smaszno.payu.services.PayUAuthorize;
import org.smaszno.payu.services.PayUCreateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("file:conf/payu-order.properties")
public class AppConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);




    public AppConfig() {
        LOGGER.info("init");

    }

    @Autowired
    private Environment env;

    @Bean
    public PayUAuthorize payuAuthorize() {
        return new PayUAuthorize(env);
    }

    @Bean
    public PayUCreateOrder payUCreateOrder() {
        return new PayUCreateOrder(env);
    }
}