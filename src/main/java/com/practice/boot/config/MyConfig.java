package com.practice.boot.config;

import com.practice.boot.bean.Pet;
import com.practice.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 告訴SpringBoot這是一個配置類，相當於配置文件
 * 1. 配置類裡面使用@Bean標註在方法上給容器註冊組件，默認也是單實例的
 * 2. 配置類本身也是組件
 * 3. proxyBeanMethods: 代理Bean方法(若為true(默認)，無論調用底下方法多少次，皆會拿到相同的實例)
 *
 * @author Jason
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean // 給容器添加組件，以方法名稱作為組件的id，返回類型就是組件的類型，返回的值就是組件在容器中的實例
    public User user01 () {
        return new User("Tom", 25);
    }

    @Bean("pet01")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
