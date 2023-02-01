package org.kun.kunframework.test;

import org.junit.Test;
import org.kun.kunframework.context.spport.ClassPathXmlApplicationContext;
import org.kun.kunframework.test.bean.UserService;

import org.kun.kunframework.test.event.CustomEvent;
import org.openjdk.jol.info.ClassLayout;

public class KunTest {

    String conf = "classpath:kunframework.xml";

//    public static void main(String[] args) {
//        new KunTest().test_prototype();
//    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }

    @Test
    public void test_application_aware() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:kunframework.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

//    @Test
//    public void test_BeanFactory(){
//        // 1.初始化 BeanFactory
//        BeanFactory beanFactory = new BeanFactory();
//
//        // 2.注册 bean
//        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 3.获取 bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//    }
//
//    /**
//     * 无参构造函数实例化
//     * @throws IllegalAccessException
//     * @throws InstantiationException
//     */
//    @Test
//    public void test_newInstance() throws IllegalAccessException, InstantiationException {
//        UserService userService = UserService.class.newInstance();
//        System.out.println(userService);
//    }
//
//    /**
//     * 有参构造实例化
//     * @throws Exception
//     */
//    @Test
//    public void test_constructor() throws Exception {
//        Class<UserService> userServiceClass = UserService.class;
//        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
//        UserService userService = declaredConstructor.newInstance("kun");
//        System.out.println(userService);
//    }
//
//    /**
//     * 使用Cglib实例化
//     */
//    @Test
//    public void test_cglib() {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserService.class);
//        enhancer.setCallback(new NoOp() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//        });
//        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"kun"});
//        System.out.println(obj);
//    }
//
//
//    @Test
//    public void test_BeanFactory() {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService", "kun");
//        userService.queryUserInfo();
//    }
//
//
//    /**
//     * 测试注入属性是否正确执行
//     *  【下一步我们要把设置属性信息的部分放到配置文件中去】
//     */
//    @Test
//    public void test_BeanFactory_property() {
//
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. UserDao 注册
//        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
//
//        // 3. UserService 设置属性[uId、userDao]
//        PropertyValues propertyValues = new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("id", "1"));
//        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
//
//        // 4. UserService 注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 5. UserService 获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//
//    }
//
//    /**
//     * 测试应用上下文
//     */
//    @Test
//    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 读取配置文件&注册Bean
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions("classpath:kunframework.xml");
//
//        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
//        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
//
//        // 4. Bean实例化之后，修改 Bean 属性信息
//        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
//        beanFactory.addBeanPostProcessor(beanPostProcessor);
//
//        // 5. 获取Bean对象调用方法
//        UserService userService = beanFactory.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }
//
//
//    @Test
//    public void test_xml() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:kunPostProcessor.xml");
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }

}
