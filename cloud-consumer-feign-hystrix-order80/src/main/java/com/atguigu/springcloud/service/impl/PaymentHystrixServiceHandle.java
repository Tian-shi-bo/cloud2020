package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;


@Component   //自定义降级处理类；采用OpenFegin进行远程调用，降级处理类需要实现Fegin接口
public class PaymentHystrixServiceHandle implements PaymentHystrixService {

    //为每一个接口远程方法，都定义一个降级方法
    @Override
    public String paymentInfo_OK(Integer id) {
        return "调用远程【CLOUD-HYSTRIX-PAYMENT-SERVICE】paymentInfo_OK出问题";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "调用远程【CLOUD-HYSTRIX-PAYMENT-SERVICE】paymentInfo_Timeout出问题";
    }
}
