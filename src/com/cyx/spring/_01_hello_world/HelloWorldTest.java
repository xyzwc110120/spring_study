package com.cyx.spring._01_hello_world;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Constructor;

class HelloWorldTest {

    @Test
    @DisplayName("传统方式：调用者手动来创建对象，和创建对象依赖的属性，并组装依赖关系")
    void testHelloWordByOld() {
        // 创建一个对象
        HelloWorld world = new HelloWorld();
        // 给对象设置相关的依赖属性
        world.setName("马大哈");
        world.sayHello();
    }

    @Test
    @DisplayName("使用 Spring 的 IoC（控制反转）和 DI（依赖注入）")
    void testHelloWorldByIoCAndDI() {
        HelloWorld world = null;

        // 从 classpath 路径去寻找配置文件，创建资源对象
        Resource resource = new ClassPathResource("applicationContext.xml");
        // 根据资源对象创建 Spring IoC 容器对象
        BeanFactory factory = new XmlBeanFactory(resource);
        // 从 Spring IoC 容器中获取指定名称的对象
        world = (HelloWorld) factory.getBean("helloWorld");

        world.sayHello();
    }

    @Test
    @DisplayName("模拟 Spring IoC 容器操作")
    void testSimulateSpringIoC() throws Exception {
        /* 使用 DOM4J 读取 applicationContext.xml 文件 */
        // 获取 applicationContext.xml 文件流对象
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("applicationContext.xml");
        // 创建 Document 对象
        Document document = new SAXReader().read(stream);
        // 循环根元素的 bean 子元素，并获取 id 属性值为 helloWorld 的元素对象
        Element beanElement = null;
        for (Element element : document.getRootElement().elements("bean")) {
            if ("helloWorld".equals(element.attributeValue("id"))) {
                beanElement = element;
            }
        }

        /* 使用反射创建对象 */
        assert beanElement != null;
        // 通过 Element 对象获取配置的类的全限定名，并创建该类的字节码对象
        Class clz = Class.forName(beanElement.attributeValue("class"));
        /* 注意：使用 Spring IoC 管理的 bean 必须要有无参构造方法，不管该构造方法的访问权限是什么（就算是 private 也可以） */
        // 获取该类的无参构造器对象
        Constructor constructor = clz.getConstructor();
        // 设置构造器的可访问性，这样就算是 private 权限也可以访问
        constructor.setAccessible(true);
        // 创建对象
        Object obj = constructor.newInstance();

        /* 使用内省机制为对象的属性赋值 */
        // 获取 bean 的 BeanInfo 对象
        BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
        // 遍历 bean 的所有属性描述器对象，并且如果属性描述器对象中有属性名与配置文件中 bean 元素的 property 子元素的 name 属性值相同的话，则设置属性值
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            // 获取 bean 元素的 property 子元素
            for (Element propertyElement : beanElement.elements("property")) {
                if (descriptor.getName().equals(propertyElement.attributeValue("name"))) {
                    descriptor.getWriteMethod().invoke(obj, propertyElement.attributeValue("value"));
                }
            }
        }

        // 调用 bean 对象的 sayHello() 方法
        clz.getMethod("sayHello").invoke(obj);
    }

    @Test
    @DisplayName("测试 Spring IoC 容器中获取 bean 对象的三种方式")
    void testGetBean() {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));

        /*
            方式一：Object getBean(String name)：
                根据配置文件中 bean 元素的 id 属性值来获取指定的 bean 对象。该方式返回的是 Object 类型的对象，需要手动强转。
        */
        HelloWorld world1 = (HelloWorld) factory.getBean("helloWorld");
        world1.sayHello();

        /*
            方式二：<T> T getBean(Class<T> requiredType):
                根据指定的类型去寻找对象。此方法不需要强转，但是如果配置文件中有两个 bean 元素都是该类型，则会报错。
        */
        HelloWorld world2 = factory.getBean(HelloWorld.class);
        world2.sayHello();

        /*
            方式三（推荐）：<T> T getBean(String name, Class<T> requiredType)：
                结合方式一和方式二，根据 id 名称 + bean 类型去寻找，既不需要强转也不用担心多个 bean 元素使用该类型。
        */
        HelloWorld world3 = factory.getBean("helloWorld", HelloWorld.class);
        world3.sayHello();
    }

}