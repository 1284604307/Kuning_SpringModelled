package org.kun.kunframework.test;

import org.junit.Test;
import org.kun.kunframework.beans.factory.support.DefaultListableBeanFactory;
import org.kun.kunframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.kun.kunframework.test.bean.UserService;

public class ResourceBeanRegistryTest {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath: kunframework.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();

        System.out.println("测试结果：" + result);
    }

}
