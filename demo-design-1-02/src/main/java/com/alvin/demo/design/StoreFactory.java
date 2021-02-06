package com.alvin.demo.design;

import com.alvin.demo.design.store.ICommodity;
import com.alvin.demo.design.store.Impl.CardCommodityService;
import com.alvin.demo.design.store.Impl.CouponCommodityService;
import com.alvin.demo.design.store.Impl.GoodsCommodityService;

public class StoreFactory {

    public ICommodity getCommdityService(Integer commdityType) {
        if (null == commdityType) {
            return null;
        }
        if (1 == commdityType) {
            return new CouponCommodityService();
        }
        if (2 == commdityType) {
            return new GoodsCommodityService();
        }
        if (3 == commdityType) {
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品的服务类型");
    }
}
