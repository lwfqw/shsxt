package com.lwf.Redis;

import com.lwf.POJO.Panda;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: TestJedis
 * @projectName noSql
 * @description: TODO
 * @date 2020/10/2719:37
 */
public class TestJedis {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.lpush("lwf", "user adminer");
        System.out.println(jedis.lpop("lwf"));
        jedis.flushAll();
        System.out.println(jedis.lpop("lwf"));
        jedis.hset("xly", "from", "ganzhou");
        System.out.println(jedis.hmget("xly","from"));
        Map<String,String> map=new HashMap<>();
        map.put("二狗","边牧");
        map.put("大狗","二哈");
        jedis.hmset("二哈",map);
        System.out.println(jedis.hmget("二哈", "二狗"));
        jedis.del("二哈");
        Panda panda=new Panda(2,"熊猫","四川");
        Map<String,String> map1=new HashMap<>();
        map1.put("大熊猫",panda.toString());
        jedis.hmset("panda", map1);
        System.out.println(jedis.hmget("panda","大熊猫"));
        jedis.del("panda");

        jedis.hset("食铁兽", map1);
        System.out.println(jedis.hget("食铁兽", "大熊猫"));
        jedis.del("食铁兽");
        jedis.close();
    }
}
