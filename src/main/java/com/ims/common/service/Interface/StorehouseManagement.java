package com.ims.common.service.Interface;

import com.ims.domain.Storehouse;

public interface StorehouseManagement {
    String addStorehouse(Storehouse storehouse);

    String selectStorehouseById(Integer storehouseId);

    String selectStorehouseByRegion(String region, Integer offset, Integer limit);

    String selectStorehouseEnabled(Integer offset, Integer limit);

    String selectStorehouseDisabled(Integer offset, Integer limit);

    String selectAllStorehouse(Integer offset, Integer limit);

    String modifyStorehouse(Storehouse storehouse);

    String deleteStorehouse(Storehouse storehouse);
}
