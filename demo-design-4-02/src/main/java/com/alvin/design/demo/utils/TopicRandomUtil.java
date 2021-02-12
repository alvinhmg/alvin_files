package com.alvin.design.demo.utils;

import java.util.*;

public class TopicRandomUtil {

    /**
     * 乱序Map元素，记录对应答案key
     * @param options 题目
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */

    public static Topic random(Map<String, String> options, String key) {

        Set<String> keySet = options.keySet();
        ArrayList<String> keyList = new ArrayList<String>(keySet);

        Collections.shuffle(keyList);
        Map<String,String> optionNew = new HashMap<String, String>();
        int index = 0;
        String keyNew = "";
        for (String next : keySet) {
            String randomKey = keyList.get(index ++);
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, options.get(next));
        }
        return new Topic(optionNew, keyNew);

    }

}
