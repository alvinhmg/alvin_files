package com.alvin.demo.design.goods;

import com.alibaba.fastjson.JSON;

/**
 * @Author alvin
 * @Description //模拟实物商品服务
 * @Date 20:35 2020-12-01
 * @Param
 * @return
 **/
public class GoodsService {
    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}
