package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 赵官乔
 */
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
public class LogisticsMain {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsMain.class, args);
    }
}
