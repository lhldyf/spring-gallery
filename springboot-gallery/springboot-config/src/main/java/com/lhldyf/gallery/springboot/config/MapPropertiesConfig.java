package com.lhldyf.gallery.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhldyf
 * @date 2019-05-29 17:33
 */
@Configuration
@ConfigurationProperties
@PropertySource("classpath:map.properties")
public class MapPropertiesConfig {

    private static Map<String, String> bootMap = new HashMap<>();

    public Map<String, String> getBootMap() {
        return bootMap;
    }

    public static String getBootMap(String metricSubType) {
        return bootMap.get(metricSubType);
    }


    public void setBootMap(Map<String, String> bootMap) {
        MapPropertiesConfig.bootMap = bootMap;
    }
}
