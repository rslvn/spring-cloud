package com.example.springcloud.configclient.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "third")
public class ThirdProfileProps {

    private String id;
    private long count;
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
}
