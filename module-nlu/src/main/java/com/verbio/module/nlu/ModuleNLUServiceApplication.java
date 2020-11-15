package com.verbio.module.nlu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients("com.verbio.module.nlu.proxy")
public class ModuleNLUServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ModuleNLUServiceApplication.class, args);
    }

    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
