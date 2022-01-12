package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * JDK 实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiation(BeanDefinition beanDefinition, String name, Constructor ctor, Object[] args) throws BeansException {

        Class clazz = beanDefinition.getBeanClass();
        try{
            if(null != ctor){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e){
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
