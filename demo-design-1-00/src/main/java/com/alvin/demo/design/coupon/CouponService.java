package com.alvin.demo.design.coupon;

/**
 * @Author alvin
 * @Description //模拟优惠券服务
 * @Date 20:20 2020-12-01
 * @Param
 * @return
 **/
public class CouponService {

    public CouponResult sendCoupon(String uId, String couponHNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponHNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }
}
