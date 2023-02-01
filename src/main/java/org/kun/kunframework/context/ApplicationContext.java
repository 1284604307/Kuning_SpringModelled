package org.kun.kunframework.context;

import org.kun.kunframework.beans.factory.HierarchicalBeanFactory;
import org.kun.kunframework.beans.factory.ListableBeanFactory;
import org.kun.kunframework.core.io.ResourceLoader;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 * <p>
 * 应用上下文
 * <p>
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}

