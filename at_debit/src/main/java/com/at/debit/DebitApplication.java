package com.at.debit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@MapperScan(basePackages = {"com.at.debit.mapper"}) // mybatis包扫描
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = "com.at")
public class DebitApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebitApplication.class, args);
    }

}
