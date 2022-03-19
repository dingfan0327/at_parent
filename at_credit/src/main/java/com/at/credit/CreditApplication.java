package com.at.credit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan(basePackages = {"com.at.credit.mapper"}) // mybatis包扫描
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = "com.at")
public class CreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditApplication.class, args);
    }

}
