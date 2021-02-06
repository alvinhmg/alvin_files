package com.alvin.demo.design.test;

import com.alvin.demo.design.CacheService;
import com.alvin.demo.design.factory.JDKProxy;
import com.alvin.demo.design.factory.impl.EGMCacheAdapter;
import com.alvin.demo.design.factory.impl.IIRCacheAdapter;
import com.alvin.demo.design.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testCacheService() throws Exception {
        CacheService proxyEGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxyEGM.set("user_name_01", "小傅哥");
        String val01 = proxyEGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        CacheService proxyIRR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxyIRR.set("user_name", "alvin");
        String val02 = proxyIRR.get("user_name");
        System.out.println("测试结果："+ val02);

    }

}
