package com.practice.boot;

import ch.qos.logback.core.db.DBHelper;
import com.practice.boot.bean.Pet;
import com.practice.boot.bean.User;
import com.practice.boot.config.MyConfig;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jason
 * 這是一個主程序類
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("====================");

        Pet tom01 = ctx.getBean("pet01", Pet.class);
        Pet tom02 = ctx.getBean("pet01", Pet.class);
        System.out.println(tom01 == tom02);

        System.out.println("====================");

        MyConfig myConfig = ctx.getBean(MyConfig.class);
        System.out.println(myConfig);

        System.out.println("====================");

        // @Configuration(proxyBeanMethods = true)代理對象調用方法。SpringBoot總會檢查這個組件是否在容器有
        // 保持組件單實例
        User user01 = myConfig.user01();
        User user02 = myConfig.user01();
        System.out.println(user01 == user02);

        System.out.println("====================");

        JSONArray jsonArray = new JSONArray(new ArrayList<>());
        System.out.println("000=" + jsonArray.isEmpty());

        JSONArray jsonArray1 = new JSONArray(Arrays.asList("111"));
        System.out.println("111=" + jsonArray1);
        System.out.println("111=" + jsonArray1.isEmpty());

        JSONArray jsonArray2 = new JSONArray(10);
        System.out.println("222=" + jsonArray2);
        System.out.println("222=" + jsonArray2.length());
        System.out.println("222=" + jsonArray2.isEmpty());

        System.out.println("====================");

        String[] beanNamesForType = ctx.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = ctx.getBean(DBHelper.class);
        System.out.println(bean1);
    }
}
