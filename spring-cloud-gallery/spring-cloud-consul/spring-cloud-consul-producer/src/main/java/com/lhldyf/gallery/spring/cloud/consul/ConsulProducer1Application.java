package com.lhldyf.gallery.spring.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lhldyf
 * @date 2019-05-26 12:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProducer1Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProducer1Application.class, args);
    }
}
