package com.konstde00.applicationmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class },
    scanBasePackages = {"com.konstde00.authenticationmodule", "com.konstde00.designfacultymodule",
        "com.konstde00.businessfacultymodule", "com.konstde00.medicinefacultymodule"})
public class Application {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
