package cn.xqs.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker//开启熔断
@SpringCloudApplication
@EnableFeignClients//打开feign的客户端
public class XqsServiceConsumerApplication {

//    @Bean
//    @LoadBalanced//开启负载均衡
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(XqsServiceConsumerApplication.class, args);
    }

}
