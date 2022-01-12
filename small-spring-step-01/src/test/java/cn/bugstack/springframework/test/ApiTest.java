package cn.bugstack.springframework.test;

import cn.bugstack.springframework.BeanDefinition;
import cn.bugstack.springframework.BeanFactory;
import org.junit.Test;
import cn.bugstack.springframework.test.bean.UserService;


public class ApiTest {
    @Test
    public void test_BeanFactory(){
        //1、初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        //2、注册bean
        UserService userService = new UserService();
        BeanDefinition beanDefinition = new BeanDefinition(userService);
        //3、获取bean
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService service = (UserService) beanFactory.getBean("userService");
        service.getUserInfo();
    }
}
