package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    CommonResult<Payment> create(Payment payment);
    Payment getPaymentById(Long id);
}
