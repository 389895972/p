package cn.xqs.service.client;

import cn.xqs.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-provider")
public interface UserClient {

    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id")Long id);

}
