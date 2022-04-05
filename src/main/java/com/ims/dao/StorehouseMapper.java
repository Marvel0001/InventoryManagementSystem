package com.ims.dao;

import com.ims.domain.Storehouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorehouseMapper {
    void addStorehouse(Storehouse storehouse);

    List<Storehouse> selectStorehouseById(Integer storehouseId);

    List<Storehouse> selectStorehouseByRegion(String region);

    List<Storehouse> selectStorehouseEnabled();

    List<Storehouse> selectStorehouseDisabled();

    List<Storehouse> selectAllStorehouse();

    void modifyStorehouse(Storehouse storehouse);

    void deleteStorehouse(Storehouse storehouse);
}
