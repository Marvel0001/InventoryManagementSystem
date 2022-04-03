package com.ism.common.service.Interface;

public interface StockManagement {
    String selectAll(Integer storehouseId, Integer limit, Integer offset);
    String selectByGoodId(Integer goodId, Integer storehouseId, Integer limit, Integer offset);
}
