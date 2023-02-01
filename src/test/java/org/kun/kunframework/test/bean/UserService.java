package org.kun.kunframework.test.bean;

import lombok.Data;
import org.kun.kunframework.beans.factory.BeanClassLoaderAware;
import org.kun.kunframework.beans.factory.BeanFactoryAware;
import org.kun.kunframework.beans.factory.BeanNameAware;
import org.kun.kunframework.beans.BeansException;
import org.kun.kunframework.beans.factory.BeanFactory;
import org.kun.kunframework.beans.factory.DisposableBean;
import org.kun.kunframework.beans.factory.InitializingBean;
import org.kun.kunframework.context.ApplicationContext;
import org.kun.kunframework.context.ApplicationContextAware;
import org.kun.kunframework.test.dao.IUserDao;

public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String id;
    private String company;
    private String location;
    private IUserDao userDao;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(id)+", 公司："+company+", 地点"+location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}