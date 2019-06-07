package cn.happy.fallback;

import cn.happy.service.MemberFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//将该类公开成spring中的一个bean
@Component
//定义一个普通类，实现MemberFeign 
public class MemberFallBack implements MemberFeign {
    @Override
    public List<String> getToOrderMemberAll() {
        List<String> list=new ArrayList<String>();
        list.add("服务发生异常。。。");
        return list;
    }
}