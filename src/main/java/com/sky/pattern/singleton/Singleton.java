package com.sky.pattern.singleton;

/**
 * 单例对象
 * @author JWF
 * @date 2020-11-27
 */
public class Singleton {
    private final static Singleton SINGLETON = new Singleton();

    private Singleton(){
        System.out.println("Singleton 私有构造函数");
    }

    public static Singleton getSingleton(){
        return SINGLETON;
    }
}
