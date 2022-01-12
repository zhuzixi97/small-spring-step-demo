package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();
        UserService userService1 = (UserService) defaultListableBeanFactory.getBean("userService");
        userService1.queryUserInfo();
    }
}
