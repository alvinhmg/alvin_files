package com.alvin.demo.design.test;

import com.alvin.demo.design.CacheService;
import com.alvin.demo.design.cuisine.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_cacheService() {
        CacheService cacheService = new CacheServiceImpl();

        cacheService.set("user_name", "alvin", 1);
        String value = cacheService.get("user_name", 1);

        System.out.println("测试结果" + value);
    }
}
