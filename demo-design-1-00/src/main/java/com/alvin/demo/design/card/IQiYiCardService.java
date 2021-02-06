package com.alvin.demo.design.card;

/**
 * @Author alvin
 * @Description 模拟爱奇艺会员卡服务
 * @Date 20:15 2020-12-01
 * @Param
 * @return
 **/
public class IQiYiCardService {

    public void grantToken(String bindMobelNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobelNumber + "," + cardId);
    }
}
