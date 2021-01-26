package com.practice.boot;

import com.practice.boot.bean.Pet;
import com.practice.boot.bean.User;
import com.practice.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
    }
}
