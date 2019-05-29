package com.lhldyf.gallery.springboot;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lhldyf
 * @date 2018-11-12 11:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractTester {

    public static void sleep() {
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
