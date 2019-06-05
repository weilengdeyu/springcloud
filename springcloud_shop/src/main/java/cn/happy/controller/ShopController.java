package cn.happy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2019/6/1.
 */
@RestController
public class ShopController {
    @Value("${server.port}")
    private String port;
    //控制器方法，返回的都是json数据
    @RequestMapping("/getAllShops")
    public List<String> getAllShops(){
        List<String> list=new ArrayList<String>();
        list.add("2017 Shop");
        list.add("2018 Shop");
        list.add("2019 Shop");
        list.add(port);
        return list;
    }
}
