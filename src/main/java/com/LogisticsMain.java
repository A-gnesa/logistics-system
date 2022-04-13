package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 赵官乔
 */
@SpringBootApplication
@EnableSwagger2
public class LogisticsMain {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsMain.class, args);
    }
}
