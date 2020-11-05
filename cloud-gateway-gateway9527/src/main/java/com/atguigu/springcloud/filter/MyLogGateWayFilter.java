package com.atguigu.springcloud.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
//   自定义全局过滤器  校验请求参数中是否携带username参数 是则放行
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

      //  System.out.println("自定义全局过滤器");

        //  http://localhost:9527/payment/get1?username=zhangsan&username=lisi&age=22
        // getFirst 获取第一个username  zhangsan
        String username = exchange.getRequest().getQueryParams().getFirst("username");
       // System.out.println(username);
        if (StringUtils.isEmpty(username)) {
          //  System.out.println("用户名称为空");
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);   // HttpStatus.FORBIDDEN=403  访问被拒绝
            return exchange.getResponse().setComplete(); //不放行  结束请求
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
