package com.lhldyf.gallery.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 这个注解非常关键: @ConfigurationProperties，否则不会进这里的set方法，debug进不来，bootList永远都是null
 * 2. setter/getter方法也必须要的
 * @author lhldyf
 * @date 2019-05-29 17:33
 */
@Configuration
@ConfigurationProperties
@PropertySource("classpath:list.properties")
public class ListPropertiesConfig {
    
    /**
     * 这个名称一定要与配置文件中的命名一致，否则读取为空
     */
    private static List<String> bootList = new ArrayList<>();

    public static List<String> getBootList() {
        return bootList;
    }

    public void setBootList(List<String> bootList) {
        ListPropertiesConfig.bootList = bootList;
    }
}
