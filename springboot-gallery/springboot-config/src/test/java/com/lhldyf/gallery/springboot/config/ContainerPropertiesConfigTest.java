package com.lhldyf.gallery.springboot.config;

import com.lhldyf.gallery.springboot.AbstractTester;
import org.junit.Test;

/**
 * @author lhldyf
 * @date 2019-05-29 18:24
 */
public class ContainerPropertiesConfigTest extends AbstractTester {

    @Test
    public void test() {
        System.out.println(ContainerPropertiesConfig.ListPropertiesConfig.getBootList());
        System.out.println(ContainerPropertiesConfig.MapListPropertiesConfig.getBootMapList());
        System.out.println(ContainerPropertiesConfig.MapPropertiesConfig.getBootMap());
    }

    @Test
    public void test2() {
        System.out.println(ContainerPropertiesConfig2.getBootList());
        System.out.println(ContainerPropertiesConfig2.getBootMap());
        System.out.println(ContainerPropertiesConfig2.getBootMapList());
    }

}
