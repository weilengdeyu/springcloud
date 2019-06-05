package cn.happy;

import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudMemberApplication.class, args);
	}
}
