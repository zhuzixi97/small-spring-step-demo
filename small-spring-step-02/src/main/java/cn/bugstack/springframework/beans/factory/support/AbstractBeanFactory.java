package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);

        if(bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name, beanDefinition);

    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);
}
