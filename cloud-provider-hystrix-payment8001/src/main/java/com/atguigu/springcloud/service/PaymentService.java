package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    public String paymentInfo_OK(Integer id);
    public String payment_Timeout(Integer id);
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
