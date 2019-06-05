package test;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by root on 2019/6/1.
 */
@Configuration
public class UserRuleConfig {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
