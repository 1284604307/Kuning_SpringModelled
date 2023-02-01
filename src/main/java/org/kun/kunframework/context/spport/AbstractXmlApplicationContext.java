package org.kun.kunframework.context.spport;

import org.kun.kunframework.beans.factory.support.DefaultListableBeanFactory;
import org.kun.kunframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.kun.kunframework.context.spport.AbstractRefreshableApplicationContext;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
