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
            bean = createBeanInstantiation(beanDefinition,name,args);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(name, bean);
        return bean;
    }

    protected Object createBeanInstantiation(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        //获取所有的构造函数
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            //对比参数是否为空和构造函数的参数数量与参数数组是否一致
            if(args != null && ctor.getParameterTypes().length == args.length){
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiation(beanDefinition, beanName, constructor, args);
    }

    public InstantiationStrategy getInstantiationStrategy(){
        return instantiationStrategy;
    }
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy = instantiationStrategy;
    }
}
