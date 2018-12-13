package com.vens.shop;

import com.vens.redis.JedisCallBack;
import com.vens.redis.RedisHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Arrays;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/13
 */
public class RedisTest {
    RedisHelper redisHelper;

    @Before
    public void testBefore() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
        this.redisHelper = (RedisHelper) context.getBean("redisHelper");
    }

    @Test
    public void redis_test() {

        redisHelper.jedisExecute(jedis -> {
            return jedis.set("test_luzhiqing", "asdfghjklasdfghjklasdfghjklaaaasdfkjasfslhfsjdfhs");
        });
        String result = redisHelper.jedisExecute(jedis -> {
            return jedis.get("test_luzhiqing");
        });
        Assert.assertEquals("asdfghjklasdfghjklasdfghjklaaaasdfkjasfslhfsjdfhs", result);
    }

    @Test
    public void lua_script_use() {
        redisHelper.jedisExecute(jedis -> {
            return jedis.set("test_luzhiqing", "vens");
        });
        //lua脚本参数数组的起始位置是1，KEYS[1]是第一位
        //语法:https://blog.csdn.net/Ditto_zhou/article/details/79446196
        final String luaScript = "if redis.call(\"get\",KEYS[1])==ARGV[1] then \n" +
                "\tredis.call(\"set\",KEYS[1],ARGV[2])\n" +
                "\treturn redis.call(\"get\",KEYS[1])\n" +
                "else\n" +
                "\tredis.call(\"set\",KEYS[1],ARGV[3])\n" +
                "\treturn redis.call(\"get\",KEYS[1])\n" +
                "end";
       String result = redisHelper.jedisExecute(jedis -> {

            String res = (String) jedis.eval(luaScript,
                    Arrays.asList("test_luzhiqing"),
                    Arrays.asList("vens", "success", "failed"));
            return res;
        });
        System.out.println(result);
    }
    @Test
    public void redis_watch_use(){
//        redisHelper.jedisExecute(jedis -> jedis.set("watch_test","10")
//        );
        redisHelper.jedisExecute(jedis -> {
            jedis.watch("watch_test");
            new Thread(){
                @Override
                public void run() {
                    System.out.println(jedis.set("watch_test","8000"));
                }
            }.start();
            try{
                Thread.currentThread().sleep(1000*2);
            }catch (Exception e){

            }
            System.out.println("do tx");
            int res=Integer.parseInt(jedis.get("watch_test"));
            Transaction tx = jedis.multi();
            res=res*3;
            tx.set("watch_test",String.valueOf(res));
            tx.exec();
            System.out.println("do_watch:"+jedis.get("watch_test"));
            return null;
        });
    }
}
