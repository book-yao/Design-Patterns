package com.sky.pattern.singleton;

import sun.misc.IOUtils;

import java.io.*;

/**
 * 自定义类加载器
 * @author JWF
 * @date 2020-11-27
 */
public class MyClassLoader extends ClassLoader{
    private String name;
    private String classPath;

    public MyClassLoader(String name){
        super(null);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = getClassBytes(name);
        return this.defineClass(name,classBytes,0,classBytes.length);
    }

    private byte[] getClassBytes(String name){
        String classPath = this.classPath + "/"+name.replace(".","/") + ".class";
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(classPath));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer,0,buf_size) ) != -1) {
                byteArrayOutputStream.write(buffer,0,len);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }finally {
            try {
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                if(byteArrayOutputStream != null){
                    byteArrayOutputStream.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }
}
