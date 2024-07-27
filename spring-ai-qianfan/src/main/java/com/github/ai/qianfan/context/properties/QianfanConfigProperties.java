package com.github.ai.qianfan.context.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = QianfanConfigProperties.QIAN_FAN_AI_PREFIX)
public class QianfanConfigProperties {
    public static final String QIAN_FAN_AI_PREFIX = "ai.qianfan";

    private String apiKey;

    private String secretKey;
}
