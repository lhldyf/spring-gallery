package com.lhldyf.gallery.springboot.aspect.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhldyf
 * @date 2020-02-21 11:35
 */
@RestController
public class TestController {

    @RequestMapping("aspect")
    @ControllerAspectPoint
    public TestVO aspect(@RequestBody TestCondition condition) {
        TestVO testVO = new TestVO();
        testVO.setId(condition.getId());
        return testVO;
    }

    @RequestMapping("noAspect")
    public TestVO noAspect(TestCondition condition) {
        TestVO testVO = new TestVO();
        testVO.setId("1");
        return testVO;
    }
}
