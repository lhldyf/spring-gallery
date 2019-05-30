package com.lhldyf.gallery.springboot.config;

import com.lhldyf.gallery.springboot.AbstractTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author lhldyf
 * @date 2019-05-29 17:46
 */
public class SetPropertiesConfigTest extends AbstractTester {


    @Test
    public void test() {
        Assert.assertNotNull(SetPropertiesConfig.getBootSet());
        Assert.assertEquals(SetPropertiesConfig.getBootSet().size(), 2);
        System.out.println(SetPropertiesConfig.getBootSet());
    }
}
