package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

   @Value("${server.port}")
   private Integer port;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")  // @RequestBody必须要加不然获取不到消费者的json数据
    public CommonResult<Payment> create(@RequestBody Payment payment) {
       return paymentService.create(payment);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        try {
            Payment payment = paymentService.getPaymentById(id);
            if (payment==null) {
                return new CommonResult<Payment>(400,"查询数据错误");
            }else {
                return new CommonResult<Payment>(200,"查询数据成功,服务端口为："+port,payment);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResult<Payment>(999,"查询数据异常");
        }

    }
}
