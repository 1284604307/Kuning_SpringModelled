package org.kun.kunframework.beans.factory;

import org.kun.kunframework.beans.BeansException;
import org.kun.kunframework.beans.factory.Aware;
import org.kun.kunframework.beans.factory.BeanFactory;

public interface BeanFactoryAware extends Aware {

   void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
