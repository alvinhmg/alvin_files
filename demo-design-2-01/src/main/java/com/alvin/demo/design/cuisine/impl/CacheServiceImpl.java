package com.alvin.demo.design.cuisine.impl;

import com.alvin.demo.design.CacheService;
import com.alvin.demo.design.RedisUtils;
import com.alvin.demo.design.matter.EGM;
import com.alvin.demo.design.matter.IIR;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtil = new RedisUtils();

    private EGM egm = new EGM();

    private IIR iir = new IIR();


    public String get(String key, int redisType) {
        if (1 == redisType) {
            return egm.gain(key);
        }

        if (2 == redisType) {
            return iir.get(key);
        }
        return redisUtil.get(key);
    }

    public void set(String key, String value, int redisType) {
        if (1 == redisType) {
            egm.set(key, value);
            return;
        }

        if (2 == redisType) {
            iir.set(key, value);
            return;
        }

        redisUtil.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (1 == redisType) {
            egm.setEx(key, value, timeout, timeUnit);
            return;
        }

        if (2 == redisType) {
            iir.setExpire(key, value, timeout, timeUnit);
            return;
        }

        redisUtil.set(key, value, timeout, timeUnit);

    }

    public void del(String key, int redisType) {


        if (1 == redisType) {
            egm.delete(key);
            return;
        }

        if (2 == redisType) {
            iir.del(key);
            return;
        }

        redisUtil.del(key);
    }
}
