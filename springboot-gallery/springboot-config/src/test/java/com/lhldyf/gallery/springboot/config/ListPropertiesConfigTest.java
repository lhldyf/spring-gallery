package com.lhldyf.gallery.springboot.config;

import com.lhldyf.gallery.springboot.AbstractTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author lhldyf
 * @date 2019-05-29 17:46
 */
public class ListPropertiesConfigTest extends AbstractTester {


    @Test
    public void test() {
        Assert.assertNotNull(ListPropertiesConfig.getBootList());
        Assert.assertEquals(ListPropertiesConfig.getBootList().size(), 2);
    }
}
