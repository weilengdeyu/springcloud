package cn.happy.controller;

import cn.happy.service.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderFeignController {
    @Autowired
    private MemberFeign memberFeign;
    @RequestMapping("/getToOrderMemberAll")
    public List<String> getToOrderMemberAll(){
        System.out.println("order feign调度member工程");
        return memberFeign.getToOrderMemberAll();
    }
    @RequestMapping("/info")
    public String info(){
        return "info";
    }
}