package cn.xqs.service.controller;

import cn.xqs.service.client.UserClient;
import cn.xqs.service.pojo.User;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/consumer/user")
//@DefaultProperties(defaultFallback ="fallbackMethod" )//全局熔断
public class UserController {

   // @Autowired
   // private RestTemplate restTemplate;

   // @Autowired
   // private DiscoveryClient discoveryClient; //包含了拉取 的所有服务信息

    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    @HystrixCommand//(fallbackMethod = "fallbackMethod")     //声明熔断方法
    public String queryUserById(@RequestParam("id")Long id){
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        ServiceInstance instance = instances.get(0);
       // return this.restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id, User.class);
//        if(id==1){
//            System.out.println("111");
//              throw new RuntimeException();
//        }
       // return this.restTemplate.getForObject("http://service-provider/user/"+id, String.class);

        return  this.userClient.queryUserById(id).toString();
    }

//    public String fallbackMethod(Long id){
//
//        return "服务器正忙";
//    }
}
