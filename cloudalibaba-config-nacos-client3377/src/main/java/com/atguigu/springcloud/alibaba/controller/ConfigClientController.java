package com.atguigu.springcloud.alibaba.controller;


import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //通过SpringCloud原生注解@RefreshScopeqe , 若配置文件发生变化， 实现配置自动更新
public class ConfigClientController {

    @Value("${config.port}")
    private String configport;

    @Value("${config.info}")  //  从配置中心拉取配置  遵循（配置规则）才能正常拉取 配置规则再bootstrap.yml中声明
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return "configInfo"+configInfo+","+"configport"+configport;
    }
}
