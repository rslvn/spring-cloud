package com.example.springcloud.configclient.service;

import com.example.springcloud.configclient.config.SecondProfileConfig;
import com.example.springcloud.configclient.domain.ConfigParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@RefreshScope
@RequiredArgsConstructor
@Service
public class ConfigService {

    @Value("${sample.value.min}")
    private long min;

    @Value("${sample.value.max}")
    private long max;

    @Value("${sample.value.fix}")
    private String fix;

    @Value("${sample.value.label}")
    private String label;

    private final RestTemplate restTemplate;
    private final SecondProfileConfig secondProfileConfig;

    @PostConstruct
    private void postConstruct() {
        log.info("{} is started with parameters min: {}, max: {}, fix: {}, label: {}",
                this.getClass().getSimpleName(),
                this.min,
                this.max,
                this.fix,
                this.label);
    }

    @PreDestroy
    private void preDestroy() {
        log.info("{} is destroyed with parameters min: {}, max: {}, fix: {}, label: {}",
                this.getClass().getSimpleName(),
                this.min,
                this.max,
                this.fix,
                this.label);
    }

    public ConfigParams getConfig() {
        ConfigParams configParams = ConfigParams.builder()
                .min(min)
                .max(max)
                .label(label)
                .fix(fix)
                .build();
        log.info("{}", configParams);

        return configParams;
    }

    public void forceSecondProfile() {
        secondProfileConfig.getSecondProfileParams();
    }

    public void waitSome() {
        log.info("forward sleeping");
        restTemplate.getForObject("http://localhost:9090/wait", String.class);
        log.info("awaken");
    }
}
