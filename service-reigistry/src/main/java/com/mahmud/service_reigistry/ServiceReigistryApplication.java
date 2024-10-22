package com.mahmud.service_reigistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceReigistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceReigistryApplication.class, args);
	}

}
