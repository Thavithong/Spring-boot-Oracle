/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.vpg.partner.config;

import com.unitel.vpg.partner.service.TransLogImpl;
import com.unitel.vpg.partner.service.TransLogService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author stl_sdd_thavithong
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.unitel.vpg.partner.controller", "com.unitel.vpg.partner.service"})
public class WebMvcConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver.class}")
    private String driver;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public TransLogService getEmployeeDao() {
        return new TransLogImpl(getDataSource());
    }
}
