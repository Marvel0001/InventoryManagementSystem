package com.ims.dao;

import com.ims.domain.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


public interface StorageMapper {

    ArrayList<Storage> selectAll(@Param("storehouse")Integer storehouseId);

    ArrayList<Storage> selectByGoodId(@Param("goodId")Integer goodId, @Param("storehouseId") Integer storehouseId);

    ArrayList<Storage> selectByGoodName(@Param("goodName")String goodName, @Param("storehouseId")Integer storehouseId);

    ArrayList<Storage> selectByGoodType(@Param("goodType")String goodType, @Param("storehouseId")Integer storehouseId);

    void insertStorage(@Param("goodId")Integer goodId, @Param("storehouseId")Integer storehouseId, @Param("amount")Integer amount);

    void updateStorage(@Param("goodId")Integer goodId, @Param("storehouseId")Integer storehouseId, @Param("amount")Integer amount);

    void deleteStorage(@Param("goodId")Integer goodId, @Param("storehouseId")Integer storehouseId);
}
