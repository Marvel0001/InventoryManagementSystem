package com.ims.common.service.Interface;

import com.ims.domain.Storehouse;

import java.util.ArrayList;

public interface StorehouseManagement {
    String addStorehouse(Storehouse storehouse);

    String selectStorehouseById(Integer storehouseId);

    String selectStorehouseByRegion(String region, Integer offset, Integer limit);

    String selectStorehouseEnabled(Integer offset, Integer limit);

    String selectStorehouseDisabled(Integer offset, Integer limit);

    String selectAllStorehouse(Integer offset, Integer limit);

    String _selectCommon(ArrayList<Storehouse> storehouses);

    String modifyStorehouse(Storehouse storehouse);

    String deleteStorehouse(Storehouse storehouse);
}
