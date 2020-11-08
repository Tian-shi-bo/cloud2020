package com.atguigu.springcloud.alibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";

    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        log.info("testD 测试异常比例");
        //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        int i = 1/0;
        return "------testD";
    }


    //热点key限流，对特殊数据控制访问
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }
    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }
}
