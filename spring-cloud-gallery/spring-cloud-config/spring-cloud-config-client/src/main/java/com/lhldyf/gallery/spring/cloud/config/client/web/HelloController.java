package com.lhldyf.gallery.spring.cloud.config.client.web;

import com.lhldyf.gallery.spring.cloud.common.ProducerController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * 结合actuator，加上这里的@RefreshScope注解，可以让应用不重启即可刷新读取配置文件的内容
 * @author lhldyf
 * @date 2019-05-26 22:00
 */

@RefreshScope
@RestController
public class HelloController extends ProducerController {

    @Value("${neo.hello: default}")
    private String name;

    @Override
    public String name() {
        return this.name;
    }
}
