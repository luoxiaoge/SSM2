import com.alibaba.fastjson.JSON;
import com.luoc.entity.TreeNode;
import com.luoc.entity.User;
import com.sun.javafx.logging.Logger;
import domain.entity.Son;
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
import java.util.*;

import redis.clients.jedis.Jedis;

/**
 * @author luoc
 * @date 2018/12/6 0006
 * @Time 15:39
 */


public class UserTest {



    public static void main(String[] args) {
       ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("Spring/spring-luoc.xml");
        //XmlBeanFactory  factory = new XmlBeanFactory(new ClassPathResource("Spring/spring-luoc.xml"));
         User user = (User) factory.getBean("user");
        Assert.assertNotNull("User must be null",user);
        System.out.println(JSON.toJSONString(user));
        //Map ttMap = new HashMap<>();
        /*
        JedisPool jedisPool  = (JedisPool) factory.getBean("jedisPool");
        System.out.println(jedisPool);
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.set("love","son"));
        System.out.println(jedis.get("love"));
        System.out.println(jedis.keys("*"));*/

        /*
        Map<String,Object> linkMap = new LinkedHashMap<>();
        Map<String,Object> hashMap = new HashMap<>(4);

        linkMap.put("A",65);
        linkMap.put("B",66);
        linkMap.put("C",67);
        linkMap.put("D",68);
        linkMap.put("1", "Level 1");
        linkMap.put("2", "Level 2");
        linkMap.put("3", "Level 3");
        linkMap.put("4", "Level 4");
        linkMap.put("F", "Level F");
        linkMap.put("Q", "Level Q");


        hashMap.put("A",65);
        hashMap.put("B",66);
        hashMap.put("C",67);
        hashMap.put("D",68);
        hashMap.put("1", "Level 1");
        hashMap.put("2", "Level 2");
        hashMap.put("3", "Level 3");
        hashMap.put("4", "Level 4");
        hashMap.put("F", "Level F");
        hashMap.put("Q", "Level Q");


        // 遍历 map
        Iterator iterator = linkMap.entrySet().iterator();
        Iterator it = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry e = (Map.Entry) iterator.next();
            System.out.println(e.getKey()+"_____"+e.getValue());
        }

        System.out.println("=============================");
        while (it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey()+"_____"+e.getValue());
        }*/


        /*
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }*/

        /*
        Son son = Son
                .builder()
                .age(1)
                .name("luoc")
                .build();

        Son son2 = Son
                .builder()
                .age(2)
                .name("zouq")
                .build();

        Son son3 = Son
                .builder()
                .age(3)
                .name("pz")
                .build();

        int son2Age = son2.getAge();
        son = son2;

        son2 = son3;

        son2.setName("pz");
        son2.setAge(5);
        System.out.println(son2Age);
        System.out.println(JSON.toJSONString(son));*/

        /*
        Map<String,Object> map = new HashMap<>(2);

        map.put("a",1);
        System.out.println(map.put("a",2));

        int a = 3;

        if (a == 3)
            System.out.println("3");
        else if (true)
            System.out.println("4");
        else
            System.out.println("5");

        if (a != 0)
            System.out.println("6");*/


       /* for (int i=1;;){
            System.out.println(i);
            i++;
        }
        */
        User c = User.builder()
                .userName("luoc")
                .passWord("123456")
                .build();

        for (User a = c;;) {
            System.out.println(JSON.toJSONString(a));
            c.setPassWord("jhgjhgj");
            System.out.println(JSON.toJSONString(a));
            break;
        }

        int a = 1, b;
        boolean q;
        System.out.println(a);



        /*
        for (int i = 0; i < 100 ; i++) {
             System.out.println(linkMap.values().toString());
            System.out.println("_______"+ hashMap.values().toString());
        }
        */

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

        TreeNode treeNode = new TreeNode();


        Map<User,Object> tMap = new TreeMap<>();
        tMap.put(user,user);

    }


    public void testForCicule(){


    }


    private void  getRoot(TreeNode a){
         if (a.getParent() == null)
               return;
         else{
             a= a.getParent();
             getRoot(a);
         }
    }
}
