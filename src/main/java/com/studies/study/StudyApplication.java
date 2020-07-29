package com.studies.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
//        new SpringApplicationBuilder(StudyApplication.class).headless(false).web(WebApplicationType.NONE).run(args);
    }
}
