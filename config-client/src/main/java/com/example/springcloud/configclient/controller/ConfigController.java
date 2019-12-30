package com.example.springcloud.configclient.controller;

import com.example.springcloud.configclient.config.SecondProfileConfig;
import com.example.springcloud.configclient.domain.ConfigParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@Slf4j
@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/config")
public class ConfigController {

    @Value("${sample.value.min}")
    private long min;

    @Value("${sample.value.max}")
    private long max;

    @Value("${sample.value.fix}")
    private String fix;

    @Value("${sample.value.label}")
    private String label;

    private final SecondProfileConfig secondProfileConfig;
    private final RestTemplate restTemplate;

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


    @GetMapping(value = "/{property}")
    public Object getValue(@PathVariable(name = "property") String property) {

        if ("min".equalsIgnoreCase(property)) {
            return min;
        } else if ("max".equalsIgnoreCase(property)) {
            return max;
        } else if ("fix".equalsIgnoreCase(property)) {
            return fix;
        } else if ("label".equalsIgnoreCase(property)) {
            return label;
        }
        throw new RuntimeException("Unknown property");
    }

    @GetMapping(value = "/")
    public ConfigParams getAll() {
        ConfigParams configParams = ConfigParams.builder()
                .min(min)
                .max(max)
                .label(label)
                .fix(fix)
                .build();
        log.info("{}", configParams);

        return configParams;
    }

    @GetMapping(value = "/force/second-profile")
    public void forceSecondProfile() {
        secondProfileConfig.configLogger();
    }

    @GetMapping(value = "/wait")
    public void waitSome() throws InterruptedException {
        log.info("forward sleeping");
        restTemplate.getForObject("http://localhost:9090/wait", String.class);
        log.info("awaken");
    }

}
