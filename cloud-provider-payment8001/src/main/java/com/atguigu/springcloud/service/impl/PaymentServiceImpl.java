package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {



    @Autowired
    private PaymentDao paymentDao;

    @Override
    public CommonResult<Payment> create(Payment payment) {
        try {
            int i = paymentDao.create(payment);

            if (i==1) {
                return new CommonResult<Payment>(200,"插入数据库成功",payment);
            }else {
                return new CommonResult<Payment>(400,"插入数据库失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new CommonResult<Payment>(999,"插入过程异常:"+e.getMessage());
        }
    }


    @Override
    public Payment getPaymentById( Long id){
       return paymentDao.getPaymentById(id);
    }
}
