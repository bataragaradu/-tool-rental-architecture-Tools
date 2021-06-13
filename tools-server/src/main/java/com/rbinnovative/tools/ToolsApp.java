package com.rbinnovative.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan("com.rb.innovative.client.controller")
public class ToolsApp {
    public static void main(String[] args) {
        SpringApplication.run(ToolsApp.class, args);
    }


}
