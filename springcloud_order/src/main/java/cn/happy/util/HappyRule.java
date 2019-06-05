package cn.happy.util;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by root on 2019/6/1.
 * 写一个为随机
 */

public class HappyRule extends AbstractLoadBalancerRule {
    Random rand;
    private int  nowIndex=-1; //现在的下标
    private int lastIndex=-1;
    private int skipIndex=-1;

    public HappyRule() {
      rand=new Random();
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if(lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if(Thread.interrupted()) {
                    return null;
                }

                List upList = lb.getReachableServers();
                List allList = lb.getAllServers();
                int serverCount = allList.size();
                if(serverCount == 0) {
                    return null;
                }

                int index = rand.nextInt(serverCount);
                System.out.println("当前下标"+index);
                if (index==skipIndex){
                    System.out.println("跳过");
                    index = rand.nextInt(serverCount);
                    lastIndex=-1;
                    System.out.println("跳过之后的下标"+index);
                }
                skipIndex=-1;
                nowIndex=index;
                if (nowIndex==lastIndex){
                    System.out.println("需要跳过的下标"+nowIndex);
                    skipIndex=nowIndex;
                }
                server = (Server)upList.get(index);
                lastIndex=index;
                if(server == null) {
                    Thread.yield();
                } else {
                    if(server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
