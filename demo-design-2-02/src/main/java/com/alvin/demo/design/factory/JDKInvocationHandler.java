package com.alvin.demo.design.factory;
import com.alvin.demo.design.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter iCacheAdapter;

    public JDKInvocationHandler(ICacheAdapter iCacheAdapter) {
        this.iCacheAdapter = iCacheAdapter;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(iCacheAdapter, args);
    }
}
