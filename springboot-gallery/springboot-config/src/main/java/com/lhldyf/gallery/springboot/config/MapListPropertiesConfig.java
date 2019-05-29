package com.lhldyf.gallery.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 这个注解非常关键: @ConfigurationProperties，否则不会进这里的set方法，bootMap永远都是null
 * 2. setter/getter方法也必须要的
 * @author lhldyf
 * @date 2019-05-29 17:33
 */
@Configuration
@ConfigurationProperties
@PropertySource("classpath:map-list.properties")
public class MapListPropertiesConfig {

    /**
     * 这个名称一定要与配置文件中的命名一致，否则读取为空
     */
    private static Map<String, List<String>> bootMapList = new HashMap<>();

    public Map<String, List<String>> getBootMapList() {
        return bootMapList;
    }

    public void setBootMapList(Map<String, List<String>> bootMapList) {
        MapListPropertiesConfig.bootMapList = bootMapList;
    }
}
