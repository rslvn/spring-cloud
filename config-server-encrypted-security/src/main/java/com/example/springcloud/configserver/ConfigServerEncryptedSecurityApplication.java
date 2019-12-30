package com.example.springcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerEncryptedSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerEncryptedSecurityApplication.class, args);
	}

}
