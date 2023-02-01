package org.kun.kunframework.beans.factory;

import org.kun.kunframework.beans.factory.Aware;

public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);

}
