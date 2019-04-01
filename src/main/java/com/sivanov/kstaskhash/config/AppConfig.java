package com.sivanov.kstaskhash.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(value = {HashProperties.class})
@PropertySource(value = {"classpath:application.properties", "file:config/hash.properties"})
public class AppConfig {
}
