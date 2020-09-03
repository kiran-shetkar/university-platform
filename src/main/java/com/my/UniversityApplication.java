package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//https://www.javaguides.net/2018/09/spring-boot-2-jersey-rest-jpa-hibernate-5-crud-rest-apis-example.html
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//https://www.baeldung.com/spring-boot-failed-to-configure-data-source
public class UniversityApplication {
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }
}