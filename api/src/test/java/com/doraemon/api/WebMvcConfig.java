package com.doraemon.api;

import org.junit.Test;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * @author tubei
 */
@ComponentScan({"com.doraemon.data", "com.doraemon.dal", "com.doraemon.biz"})
@TestPropertySource({"classpath:application.yml", "classpath:application-dev.yml"})
@Configuration
public class WebMvcConfig {
}
