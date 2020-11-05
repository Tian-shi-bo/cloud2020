package com.atguigu.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *      Ribbon有多种负载均衡策略：
 *      自定义的随机负载均衡策略RandomRule， 默认为轮询.RoundRobinRule
 *
 */
@SpringBootConfiguration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule(); //定义为随机
    }
}
