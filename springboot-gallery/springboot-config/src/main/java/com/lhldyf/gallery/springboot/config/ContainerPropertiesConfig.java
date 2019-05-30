package com.lhldyf.gallery.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 可以把配置类放在一起
 * @author lhldyf
 * @date 2019-05-29 18:23
 */
public class ContainerPropertiesConfig {

    @Configuration
    @ConfigurationProperties
    @PropertySource("classpath:list.properties")
    public static class ListPropertiesConfig {
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


    @Configuration
    @ConfigurationProperties
    @PropertySource("classpath:map-list.properties")
    public static class MapListPropertiesConfig {

        /**
         * 这个名称一定要与配置文件中的命名一致，否则读取为空
         */
        private static Map<String, List<String>> bootMapList = new HashMap<>();

        public static Map<String, List<String>> getBootMapList() {
            return bootMapList;
        }

        public void setBootMapList(Map<String, List<String>> bootMapList) {
            MapListPropertiesConfig.bootMapList = bootMapList;
        }
    }


    @Configuration
    @ConfigurationProperties
    @PropertySource("classpath:map.properties")
    public static class MapPropertiesConfig {

        /**
         * 这个名称一定要与配置文件中的命名一致，否则读取为空
         */
        private static Map<String, String> bootMap = new HashMap<>();

        public static Map<String, String> getBootMap() {
            return bootMap;
        }

        public static String getBootMap(String metricSubType) {
            return bootMap.get(metricSubType);
        }


        public void setBootMap(Map<String, String> bootMap) {
            MapPropertiesConfig.bootMap = bootMap;
        }
    }
}
