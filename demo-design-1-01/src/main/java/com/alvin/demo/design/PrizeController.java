package com.alvin.demo.design;

import com.alibaba.fastjson.JSON;
import com.alvin.demo.design.card.IQiYiCardService;
import com.alvin.demo.design.coupon.CouponResult;
import com.alvin.demo.design.coupon.CouponService;
import com.alvin.demo.design.goods.DeliverReq;
import com.alvin.demo.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author alvin
 * @Description //模拟发奖服务
 * @Date 23:15 2020-12-02
 * @Param
 * @return
 **/

public class PrizeController {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUsers(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            logger.info("奖品发放开始{}, req:{}", req.getuId(), reqJson);
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }

            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getuId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            logger.info("奖品发放完成{}", req.getuId());
        } catch (Exception e) {
            logger.error("奖品发放失败{}, req:{}", req.getuId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }
        return awardRes;
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "123133232199";
    }
}
