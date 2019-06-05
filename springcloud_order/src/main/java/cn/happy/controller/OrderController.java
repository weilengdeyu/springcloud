package cn.happy.controller;

import cn.happy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by root on 2019/5/29.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/getOrderUsers")
    public List<String> getOrderUsers(){
        System.out.println("订单服务开始调度会员服务，调度中.....");
        return orderService.getAllUserService();
    }

    @RequestMapping("/getOrderShops")
    public List<String> getOrderShops(){
        System.out.println("订单服务开始调度购物车服务，调度中.....");
        return orderService.getAllShopService();
    }
}
