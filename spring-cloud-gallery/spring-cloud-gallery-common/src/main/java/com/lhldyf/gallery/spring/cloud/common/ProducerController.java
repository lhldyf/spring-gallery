package com.lhldyf.gallery.spring.cloud.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lhldyf
 * @date 2019-05-26 18:13
 */
public abstract class ProducerController {

    @Value("${server.port:0000}")
    private String port;

    @RequestMapping("/hello")
    public String hello() {
        return "hello consul from port: " + this.port + " " + name();
    }

    public String name() {
        return "";
    }

}
