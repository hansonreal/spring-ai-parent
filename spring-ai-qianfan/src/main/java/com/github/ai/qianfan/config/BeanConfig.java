package com.github.ai.qianfan.config;

import com.baidubce.qianfan.Qianfan;
import com.baidubce.qianfan.core.auth.Auth;
import com.github.ai.qianfan.context.properties.QianfanConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@EnableConfigurationProperties({
        QianfanConfigProperties.class
})
@Configuration
public class BeanConfig {

    @Bean
    public Qianfan qianfan(QianfanConfigProperties configProperties) {
        String apiKey = configProperties.getApiKey();
        String secretKey = configProperties.getSecretKey();
        log.info(" qianfan api key: {}, secretKey: {}", apiKey, secretKey);
        return new Qianfan(Auth.TYPE_OAUTH,apiKey, secretKey);
    }

}
