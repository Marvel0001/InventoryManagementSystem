package com.ism.dao;

import com.ism.domain.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    List<Storage> selectAll(@Param("storehouse") Integer storehouseId);

    List<Storage> selectByGoodId(@Param("goodId")Integer goodId, @Param("storehouseId") Integer storehouseId);

    List<Storage> selectByGoodName(@Param("goodName")String goodName, @Param("storehouseId")Integer storehouseId);
}
