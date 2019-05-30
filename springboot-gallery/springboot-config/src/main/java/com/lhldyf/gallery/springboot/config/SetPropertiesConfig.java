package com.lhldyf.gallery.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. 这个注解非常关键: @ConfigurationProperties，否则不会进这里的set方法，debug进不来，bootSet永远都是null
 * 2. setter/getter方法也必须要的
 * @author lhldyf
 * @date 2019-05-29 17:33
 */
@Configuration
@ConfigurationProperties
@PropertySource("classpath:set.properties")
public class SetPropertiesConfig {

    /**
     * 这个名称一定要与配置文件中的命名一致，否则读取为空
     */
    private static Set<String> bootSet = new HashSet<>();

    public static Set<String> getBootSet() {
        return bootSet;
    }

    public void setBootSet(Set<String> bootSet) {
        SetPropertiesConfig.bootSet = bootSet;
    }
}
