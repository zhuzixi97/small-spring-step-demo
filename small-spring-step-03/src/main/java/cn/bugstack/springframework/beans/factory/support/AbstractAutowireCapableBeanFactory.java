package cn.bugstack.springframework.beans.factory.support;


import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try{
            bean = createBeanInstance(name, beanDefinition, args);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(name, bean);
        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args){
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            if(null != args && args.length == declaredConstructor.getParameterTypes().length){
                constructor = declaredConstructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,beanName,constructor,args);
    }


}
