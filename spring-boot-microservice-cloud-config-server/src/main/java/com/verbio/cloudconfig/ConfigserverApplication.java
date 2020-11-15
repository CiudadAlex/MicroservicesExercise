package com.verbio.cloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ConfigserverApplication.
 *
 * @author Alejandro
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigserverApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConfigserverApplication.class, args);
    }
}
