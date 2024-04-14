package com.wjadczak.groomerMsg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GroomerMsgApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroomerMsgApplication.class, args);
	}
}
