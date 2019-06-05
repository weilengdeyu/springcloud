package cn.happy;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import test.ShopRuleConfig;
import test.UserRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@RibbonClients({@RibbonClient(name = "service-member",configuration = UserRuleConfig.class),
		@RibbonClient(name = "service-shop",configuration = ShopRuleConfig.class)})
@EnableHystrix

public class SpringcloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudOrderApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
