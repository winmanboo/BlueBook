package com.winmanboo.bluebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author winmanboo
 * @date 2023/5/23 11:51
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.winmanboo.bluebook.api.**.feign")
public class UaaApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
    }
}
