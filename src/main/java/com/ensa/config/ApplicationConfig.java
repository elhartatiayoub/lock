package com.ensa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.ensa.repository")
@ComponentScan({ "com.ensa" })
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {

}
