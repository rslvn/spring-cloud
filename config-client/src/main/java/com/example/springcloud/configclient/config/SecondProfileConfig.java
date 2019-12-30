package com.example.springcloud.configclient.config;

import com.example.springcloud.configclient.domain.SecondProfileParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

    @Value("${common.property}")
    private String commonProperty;

    @PostConstruct
    private void postConstruct() {
        log.info("{} is started with parameters id: {}, nam: {}, count: {}, commonProperty: {}",
                this.getClass().getSimpleName(),
                this.id,
                this.name,
                this.count,
                this.commonProperty);
    }

    @PreDestroy
    private void preDestroy() {
        log.info("{} is destroyed with parameters id: {}, nam: {}, count: {}, commonProperty: {}",
                this.getClass().getSimpleName(),
                this.id,
                this.name,
                this.count,
                this.commonProperty);
    }

    public SecondProfileParams getSecondProfileParams() {
        return SecondProfileParams.builder()
                .id(id)
                .name(name)
                .count(count)
                .commonProperty(commonProperty)
                .build();
    }

}
