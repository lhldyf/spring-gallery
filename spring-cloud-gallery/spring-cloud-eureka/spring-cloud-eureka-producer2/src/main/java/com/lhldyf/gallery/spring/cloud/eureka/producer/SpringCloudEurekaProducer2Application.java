package com.lhldyf.gallery.spring.cloud.eureka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaProducer2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaProducer2Application.class, args);
    }

}
