package cn.happy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by root on 2019/5/29.
 */
@Service
public class OrderService {
    //知道什么意思吗？
    //将resul
    @Autowired
    private RestTemplate restTemplate;
    public List<String> getAllUserService(){
        //访问会员服务
        //Feign 方式
        return restTemplate.getForObject("http://service-member/getAllUsers",List.class);
    }

    public List<String> getAllShopService(){
        //访问会员服务
        //Feign 方式
        return restTemplate.getForObject("http://service-shop/getAllShops",List.class);
    }
}
