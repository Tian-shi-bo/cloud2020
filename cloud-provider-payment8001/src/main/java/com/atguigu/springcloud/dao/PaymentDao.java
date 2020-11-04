package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
