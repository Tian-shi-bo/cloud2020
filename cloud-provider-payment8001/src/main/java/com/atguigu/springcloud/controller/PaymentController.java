package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

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


   // @GetMapping("/payment/get/{id}")
   /* public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
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
    }*/


    @GetMapping(value = "payment/feign/timeout")  //测试超时  OpenFeign 默认等待 1 秒钟  可在yml中配置超时
    public Integer paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }


    @GetMapping(value = "payment/get/{ID}")  //测试超时  OpenFeign 默认等待 1 秒钟  可在yml中配置超时
    public String get(@PathVariable("ID") Long ID) {
        System.out.println("9527代理");
       return "8001微服务；有9527代理==port"+port;
    }
}
