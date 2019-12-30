package com.example.springcloud.configclient.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class SecondProfileParams {
    private String id;
    private long count;
    private String name;
    private String commonProperty;
}
