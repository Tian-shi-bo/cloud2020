package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")  //声明调用远程的哪个微服务
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @PostMapping("/payment/create")  // @RequestBody必须要加不然获取不到消费者的json数据
    public CommonResult<Payment> create(@RequestBody Payment payment);

    @GetMapping(value = "payment/feign/timeout")
    public Integer paymentFeignTimeout();
}
