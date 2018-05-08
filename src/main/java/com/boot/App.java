package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * the resources dir holds static files you can serve using Maven. everything in resources is in the class path and can be used
 * everything in the resources/public is the front end angular1 stuff i got for tutorial. the vid not about angular1 so dont worry too much about
 * whats inside but know that i can do it this way
 *
 * application properties first stakes the base one (no dash) the environment ones (dashed) are like the children, they will use
 * and override any specified in it and also inherit the properties from the base application.properties.
 * run->edit config->vm options->-Dspring.profiles.active=test    will change that property
 *
 * common spring boot properties
 * https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
}
