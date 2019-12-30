package com.example.thirdparty.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@SpringBootApplication
public class ThirdPartyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyServerApplication.class, args);
	}

	@GetMapping(value = "/wait")
	public void waitSome() throws InterruptedException {
		log.info("going to sleep");
		TimeUnit.SECONDS.sleep(10);
		log.info("awaken");
	}

}
