package com.konstde00.applicationmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.konstde00.medicinefacultymodule"})
@EntityScan(basePackages = {"com.konstde00.medicinefacultymodule"})
@SpringBootApplication(scanBasePackages = {"com.konstde00.authenticationmodule",
    "com.konstde00.designfacultymodule", "com.konstde00.businessfacultymodule", "com.konstde00.medicinefacultymodule"})
public class Application {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
