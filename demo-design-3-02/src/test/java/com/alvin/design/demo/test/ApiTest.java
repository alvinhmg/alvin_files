package com.alvin.design.demo.test;

import com.alvin.design.demo.Builder;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBuilder() throws Exception {

            Builder builder = new Builder();

            // 豪华欧式
            System.out.println(builder.levelOne(132.52D).getDesc());

            // 轻奢田园
            System.out.println(builder.levelTwo(98.25D).getDesc());

            // 现代简约
            System.out.println(builder.levelThree(85.43D).getDesc());
        }
}
