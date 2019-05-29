package com.lhldyf.gallery.springboot.config;

import com.lhldyf.gallery.springboot.AbstractTester;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lhldyf
 * @date 2019-05-29 17:46
 */
public class MapListPropertiesConfigTest extends AbstractTester {

    @Autowired
    private MapListPropertiesConfig mapListPropertiesConfig;

    @Test
    public void test() {
        Assert.assertNotNull(mapListPropertiesConfig.getBootMapList());
        Assert.assertEquals(mapListPropertiesConfig.getBootMapList().size(), 2);
        Assert.assertEquals(mapListPropertiesConfig.getBootMapList().get("key1").size(), 2);
        Assert.assertEquals(mapListPropertiesConfig.getBootMapList().get("key1").get(0), "value1");
        Assert.assertEquals(mapListPropertiesConfig.getBootMapList().get("key1").get(1), "value2");
    }
}
