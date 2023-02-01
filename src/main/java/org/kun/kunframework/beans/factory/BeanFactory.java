package org.kun.kunframework.beans.factory;

import org.kun.kunframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    //为了解决Q1，我们在传入带参构造函数时，也增加参数入口
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
