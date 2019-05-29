package com.lhldyf.gallery.springboot.config;

import com.lhldyf.gallery.springboot.AbstractTester;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lhldyf
 * @date 2019-05-29 17:46
 */
public class MapPropertiesConfigTest extends AbstractTester {

    @Autowired
    private MapPropertiesConfig mapPropertiesConfig;

    @Test
    public void test() {
        Assert.assertNotNull(mapPropertiesConfig.getBootMap());
        Assert.assertEquals(MapPropertiesConfig.getBootMap("key1"), "value1");
        Assert.assertEquals(MapPropertiesConfig.getBootMap("key2"), "value2");
    }
}
