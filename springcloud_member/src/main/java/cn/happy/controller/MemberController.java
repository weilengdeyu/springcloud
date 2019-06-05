package cn.happy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2019/5/29.
 */
@RestController  //@RestController=======@Controller+@ResponseBody
public class MemberController {
    @Value("${server.port}")
    private String port;
    //控制器方法，返回的都是json数据
    @RequestMapping("/getAllUsers")
    public List<String> getAllUsers(){
        List<String> list=new ArrayList<String>();
        list.add("2017");
        list.add("2018");
        list.add("2019");
        list.add(port);
        return list;
    }
}
