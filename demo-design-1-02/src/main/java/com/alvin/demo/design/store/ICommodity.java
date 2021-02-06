package com.alvin.demo.design.store;

import java.util.Map;

public interface ICommodity {
    void sendCommodity(String uId, String commdityId, String bizId, Map<String, String> extMap) throws Exception;
}
