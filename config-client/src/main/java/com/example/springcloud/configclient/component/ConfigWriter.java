package com.example.springcloud.configclient.component;

import com.example.springcloud.configclient.config.SecondProfileConfig;
import com.example.springcloud.configclient.properties.ThirdProfileProps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@RequiredArgsConstructor
@Component
public class ConfigWriter {

    private final SecondProfileConfig secondProfileConfig;
    private final ThirdProfileProps thirdProfileProps;

    @Scheduled(fixedDelay = 5000)
    public void secondProfileConfig() {
        log.info("Current {}", secondProfileConfig.getSecondProfileParams());
    }

    @Scheduled(fixedDelay = 5000)
    public void thirdProfilePropsLogger() {
        log.info("Current {}", thirdProfileProps.toString());
    }

    @PostConstruct
    private void postConstruct() {
        log.info("{} is started",
                this.getClass().getSimpleName());
    }

    @PreDestroy
    private void preDestroy() {
        log.info("{} is destroyed",
                this.getClass().getSimpleName());
    }

}
