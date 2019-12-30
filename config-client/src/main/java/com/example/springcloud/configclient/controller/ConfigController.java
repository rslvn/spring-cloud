package com.example.springcloud.configclient.controller;

import com.example.springcloud.configclient.domain.ConfigParams;
import com.example.springcloud.configclient.service.ConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService configService;

    @GetMapping(value = "/")
    public ConfigParams getAll() {
        return configService.getConfig();
    }

    @GetMapping(value = "/force/second-profile")
    public void forceSecondProfile() {
        configService.forceSecondProfile();
    }

    @GetMapping(value = "/wait")
    public void waitSome() throws InterruptedException {
        configService.waitSome();
    }

}
