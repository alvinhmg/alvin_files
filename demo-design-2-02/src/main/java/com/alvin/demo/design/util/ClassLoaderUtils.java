package com.alvin.demo.design.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ClassLoaderUtils {

    private static Set<Class> primitiveSet = new HashSet<Class>();


    static {
        primitiveSet.add(Integer.class);
        primitiveSet.add(Long.class);
        primitiveSet.add(Float.class);
        primitiveSet.add(Double.class);
        primitiveSet.add(String.class);
        primitiveSet.add(Character.class);
        primitiveSet.add(Boolean.class);
        primitiveSet.add(Short.class);
    }

    /**
     * @Author alvin
     * @Description 得到当前的classLoader
     * @Date 22:41 2021-01-13
     * @Param []
     * @return java.lang.ClassLoader
     **/
    public static ClassLoader getCurrentClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ClassLoaderUtils.class.getClassLoader();
        }
        return cl == null ? ClassLoader.getSystemClassLoader() : cl;
    }

    /**
     * @Author alvin
     * @Description d得到当前clazz 某个类
     * @Date 22:47 2021-01-13
     * @Param [clazz]
     * @return java.lang.ClassLoader
     **/
    public static ClassLoader getClassLoader(Class<?> clazz) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        if (clazz != null) {
            classLoader = clazz.getClassLoader();
            if (classLoader != null) {
                return  classLoader;
            }
            return classLoader;
        }
        return ClassLoader.getSystemClassLoader();
    }

    /**
     * @Author alvin
     * @Description //根据类名加载class
     * @Date 23:10 2021-01-13
     * @Param [className]
     * @return java.lang.Class
     **/

    public  static Class forName(String className) throws ClassNotFoundException{
        return forName(className, true);
    }

    public static Class forName(String className, boolean initialize) throws ClassNotFoundException {
        return Class.forName(className, initialize, getCurrentClassLoader());
    }

    public static Class forName(String className, ClassLoader cl) throws ClassNotFoundException {
        return Class.forName(className, true, cl);
    }


    /**
     * @Author alvin
     * @Description //实例化一个对象（只检测了构造函数）
     * @Date 23:31 2021-01-13
     * @Param [clazz]
     * @return T
     **/
    public static <T> T newInstance(Class<T> clazz) throws Exception {
        if (primitiveSet.contains(clazz)) {
            return null;
        }
        if (clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
            Constructor constructor[] = clazz.getDeclaredConstructors();
            Constructor defaultConstructor = null;

            for (Constructor con : constructor) {
                if (con.getParameterTypes().length == 1) {
                    defaultConstructor = con;
                    break;
                }
            }
            if (defaultConstructor != null) {
                if (defaultConstructor.isAccessible()) {
                    return (T) defaultConstructor.newInstance(new Object[]{null});
                } else {
                    try {
                       defaultConstructor.setAccessible(true);
                       return (T) defaultConstructor.newInstance(new Object[]{null});
                    } finally {
                        defaultConstructor.setAccessible(false);
                    }
                }
            } else {
                throw new Exception("The " + clazz.getCanonicalName() + " has no default constructor!");
            }
        }
        try {
            return clazz.newInstance();
        } catch (Exception e) {
           Constructor<T> constructor = clazz.getDeclaredConstructor();
           if (constructor.isAccessible()) {
               throw new Exception("The " + clazz.getCanonicalName() + " has no default constructor!", e);
           } else {
               try {
                   constructor.setAccessible(true);
                   return constructor.newInstance();
               } finally {
                   constructor.setAccessible(false);
               }
           }
        }
    }

    public static Class<?>[] getClazzByArgs(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ArrayList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof LinkedList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof HashMap) {
                parameterTypes[i] = Map.class;
                continue;
            }
            if (args[i] instanceof Long){
                parameterTypes[i] = long.class;
                continue;
            }
            if (args[i] instanceof Double){
                parameterTypes[i] = double.class;
                continue;
            }
            if (args[i] instanceof TimeUnit){
                parameterTypes[i] = TimeUnit.class;
                continue;
            }
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }

    public Method getMethod(Class<?> classType, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        return classType.getMethod(methodName, parameterTypes);
    }


}
