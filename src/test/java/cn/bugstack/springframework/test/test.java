package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test(){
        Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanDefinitionMap.put("userService", beanDefinition);

        BeanDefinition userService = beanDefinitionMap.get("userService");
        createBean("userService", userService);
    }

    protected Object createBean(String name, BeanDefinition beanDefinition) {
        Map<String, Object> singletonObjects = new HashMap<String, Object>();
        Object bean = null;
        try{
            bean = beanDefinition.getBeanClass().newInstance();
        }catch (Exception e){

        }
        singletonObjects.put(name, bean);
        return bean;
    }
}
