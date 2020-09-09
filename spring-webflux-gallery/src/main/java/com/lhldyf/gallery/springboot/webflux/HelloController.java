package com.lhldyf.gallery.springboot.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author lhldyf
 * @date 2020-03-31 20:07
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        System.out.println("1");
        return Mono.just("hello");
    }

    @GetMapping("/sleep/{latency}")
    public String sleep(@PathVariable long latency) {
        System.out.println("into sleep");
        try {
            TimeUnit.MILLISECONDS.sleep(latency);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sleep";
    }

    @GetMapping("whileTrue")
    public String whileTrue() {
        while (true) {

        }
    }

    @GetMapping("/sleepHttp/{latency}")
    public String sleepHttp(@PathVariable long latency) {
        System.out.println("into sleepHttp");
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForObject("http://localhost:8080/sleep/" + latency, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sleepHttp";
    }

    @GetMapping("/sleepFlex/{latency}")
    public Mono<String> sleepFlex(@PathVariable long latency) {
        System.out.println("into sleepFlex");
        return Mono.just("sleepFlex").delayElement(Duration.ofMillis(latency));
    }
}
