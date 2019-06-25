package com.dxb.zuul;

import com.dxb.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//@SpringCloudApplication包括：
// @SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，
// 分别是SpringBoot注解、注册服务中心Eureka注解、断路器注解
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApplication555x {
    public static void main(String args[]) {
        SpringApplication.run(ZuulApplication555x.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
