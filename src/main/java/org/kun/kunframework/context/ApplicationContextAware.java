package org.kun.kunframework.context;

import org.kun.kunframework.beans.factory.Aware;
import org.kun.kunframework.beans.BeansException;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
