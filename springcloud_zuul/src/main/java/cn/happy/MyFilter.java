package cn.happy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//宽泛的方式
//让这个类变成Spring容器中的一个bean
@Component
public class MyFilter extends ZuulFilter {
   //日志对象
	private static Logger log = LoggerFactory.getLogger(MyFilter.class);

	@Override
    public String filterType() {
		return "pre";// 前置过滤器  鉴权
	}

	//路由规则 ：路由表
	@Override
	public int filterOrder() {
		return 0;// 优先级为0，数字越大，优先级越低
	}

	//是否直径filter的run方法
	public boolean shouldFilter() {
		return true; //是否执行该过滤器，此处为true，说明需要过滤
	}
	public Object run() {
		//1。拿到请求上下文    请求    响应
		RequestContext ctx = RequestContext.getCurrentContext();
		//请求对象
		//token:令牌     如何防止表单重复提交  令牌机制
		HttpServletRequest request = ctx.getRequest();//jsp servlet
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken != null) {  //证明有tokent
			return null; //有token，直接放行
		}
		//没有token
		log.warn("token is empty");
		ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(401);//
		try {
			ctx.getResponse().getWriter().write("token is empty");
			//终止
		} catch (Exception e) {
		}
		return null;

	}


}