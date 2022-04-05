package com.ims.dao;

import com.ims.domain.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    List<Storage> selectAll(@Param("storehouse")Integer storehouseId);

    List<Storage> selectByGoodId(@Param("goodId")Integer goodId, @Param("storehouseId") Integer storehouseId);

    List<Storage> selectByGoodName(@Param("goodName")String goodName, @Param("storehouseId")Integer storehouseId);

    List<Storage> selectByGoodType(@Param("goodType")String goodType, @Param("storehouseId")Integer storehouseId);

    void insertStorage(@Param("goodId")Integer goodId, @Param("storehouseId")Integer storehouseId, @Param("amount")Integer amount);

    void updateStorage(@Param("goodId")Integer goodId, @Param("storehouseId")Integer storehouseId, @Param("amount")Integer amount);

    void deleteStorage(@Param("goodId")Integer goodId, @Param("storehouseId")Integer storehouseId);

    void addStorehouse(@Param("address")String address, @Param("status")Integer status);
}
