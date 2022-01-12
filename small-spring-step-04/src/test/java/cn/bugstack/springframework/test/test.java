package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserDao;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

public class test {

    @Test
    public void test(){
        //初始化beanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        //UserDao注册
        defaultListableBeanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userName", "小哥"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //注册
        defaultListableBeanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class,propertyValues));

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.printUserName();
    }

}
