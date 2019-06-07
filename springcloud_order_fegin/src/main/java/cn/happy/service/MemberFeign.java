package cn.happy.service;

import cn.happy.fallback.MemberFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "service-member",fallback = MemberFallBack.class)
//定义一个访问Mebmer服务的接口
public interface MemberFeign {
    @RequestMapping("getAllUsers")
   public List<String> getToOrderMemberAll();
}