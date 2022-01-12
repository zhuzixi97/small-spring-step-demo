package cn.bugstack.springframework.beans.factory.support;


import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        Object bean = null;
        try{
            bean = beanDefinition.getBeanClass().newInstance();
        }catch (Exception e){

        }
        addSingleton(name, bean);
        return bean;
    }
}
