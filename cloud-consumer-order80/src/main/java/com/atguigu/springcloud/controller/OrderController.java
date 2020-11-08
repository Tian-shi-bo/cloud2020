package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    //设置此服务的请求路径
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";  //通过注册中心获取服务名称对应的服务实例

    //用来调用远程服务 ..
    @Autowired
    private RestTemplate restTemplate;  //远程调用需要进行负载均衡

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    @ResponseBody

    //==> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }
}
