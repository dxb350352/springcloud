package com.dxb.zipken.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
@RestController
public class ZipkinClientApplication999x {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientApplication999x.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //    AlwaysSampler  类，它会导出所有的span——不过还有其他选择，比如 PercentageBasedSampler 类，它会覆盖span的一部分
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @GetMapping("/zipadd")
    public String zipAdd(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return restTemplate.getForEntity("http://zipkin-client/zipadd2?a=" + a + "&b=" + b, String.class).getBody();
    }

    @GetMapping("/zipadd2")
    public String zipAdd2(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        String zipadd3 = restTemplate.getForEntity("http://zipkin-client/zipadd3?a=" + a + "&b=" + b, String.class).getBody();
        String zipadd4 = restTemplate.getForEntity("http://zipkin-client/zipadd4?a=" + a + "&b=" + b, String.class).getBody();
        if (zipadd3.equals(zipadd4)) {
            return zipadd3;
        }
        return "error";
    }

    @GetMapping("/zipadd3")
    public String zipAdd3(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        restTemplate.getForEntity("http://zipkin-client/zipadd4?a=" + a + "&b=" + b, String.class).getBody();
        return String.valueOf(a + b);
    }

    @GetMapping("/zipadd4")
    public String zipAdd4(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return String.valueOf(a + b);
    }
}
