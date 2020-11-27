package com.sky.pattern.singleton;

/**
 * 单例模式
 * @author JWF
 * @date 2020-11-27
 */
public class SingletonPattern {
    public static void main(String[] args) throws ClassNotFoundException {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton);

        MyClassLoader myClassLoader = new MyClassLoader("myClassLoader");
        System.out.println("myClassLoader--->"+myClassLoader);
        myClassLoader.setClassPath("D:/WorkSpace/Idea/Design-Patterns/target/classes");
        Class<?> aClass = myClassLoader.findClass("com.sky.pattern.singleton.Singleton");
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println("classLoader------>"+classLoader);

        Class<Singleton> singletonClass = Singleton.class;
        System.out.println("singletonClass--->"+singletonClass.getClassLoader());

        System.out.println("aClass --->"+aClass);
    }
}
