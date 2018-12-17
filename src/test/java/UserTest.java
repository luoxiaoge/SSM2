import com.alibaba.fastjson.JSON;
import com.luoc.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import redis.clients.jedis.Jedis;

/**
 * @author luoc
 * @date 2018/12/6 0006
 * @Time 15:39
 */


public class UserTest {



    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("Spring/spring-luoc.xml");
        // XmlBeanFactory  factory = new XmlBeanFactory(new ClassPathResource("Spring/spring-luoc.xml"));
       /* User user = (User) factory.getBean("user");
        Assert.assertNotNull("User must be null",user);
        System.out.println(JSON.toJSONString(user));
        Map ttMap = new HashMap<>();*/
        JedisPool jedisPool  = (JedisPool) factory.getBean("jedisPool");
        System.out.println(jedisPool);
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.set("love","son"));
        System.out.println(jedis.get("love"));
        System.out.println(jedis.keys("*"));

    }

    @Test
    public void testResource(){
        Resource resource = new ClassPathResource("a.xml");
        try {
            InputStream inputStream = resource.getInputStream();
            System.out.println(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAlibabJson(){
         User user = new User();
         user.setPassWord("123");
         user.setUserName("luoc");

        List<User> list = new ArrayList<>();

        list.add(user);

        String json = JSON.toJSONString(list);

        System.out.println(json+"-------------------------");
        List<User> list1 = JSON.parseArray(json,User.class);

        System.out.println(JSON.toJSONString(list1));




    }
}
