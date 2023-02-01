package org.kun.kunframework.test.common;

import org.kun.kunframework.beans.BeansException;
import org.kun.kunframework.beans.PropertyValue;
import org.kun.kunframework.beans.PropertyValues;
import org.kun.kunframework.beans.factory.ConfigurableListableBeanFactory;
import org.kun.kunframework.beans.factory.config.BeanDefinition;
import org.kun.kunframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
