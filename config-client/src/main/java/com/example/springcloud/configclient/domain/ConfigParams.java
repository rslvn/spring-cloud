package com.example.springcloud.configclient.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ConfigParams {
    private long min;
    private long max;
    private String fix;
    private String label;
}
