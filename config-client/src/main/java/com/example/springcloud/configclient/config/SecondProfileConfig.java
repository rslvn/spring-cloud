package com.example.springcloud.configclient.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@EnableScheduling
@Slf4j
@RefreshScope
@Configuration
public class SecondProfileConfig {

    @Value("${second.id}")
    private String id;

    @Value("${second.count}")
    private long count;

    @Value("${second.name}")
    private String name;

    @PostConstruct
    private void postConstruct() {
        log.info("{} is started with parameters id: {}, nam: {}, count: {}",
                this.getClass().getSimpleName(),
                this.id,
                this.name,
                this.count);
    }

    @PreDestroy
    private void preDestroy() {
        log.info("{} is destroyed with parameters id: {}, nam: {}, count: {}",
                this.getClass().getSimpleName(),
                this.id,
                this.name,
                this.count);
    }

    @Scheduled(fixedDelay = 5000)
    public void configLogger(){
        log.info("Current config of {} >>> id: {}, name: {}, count: {}",
                this.getClass().getSimpleName(),
                this.id,
                this.name,
                this.count);
    }

}
