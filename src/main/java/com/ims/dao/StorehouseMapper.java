package com.ims.dao;

import com.ims.domain.Storehouse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StorehouseMapper {
    void addStorehouse(Storehouse storehouse);

    ArrayList<Storehouse> selectStorehouseById(Integer storehouseId);

    ArrayList<Storehouse> selectStorehouseByRegion(String region);

    ArrayList<Storehouse> selectStorehouseEnabled();

    ArrayList<Storehouse> selectStorehouseDisabled();

    ArrayList<Storehouse> selectAllStorehouse();

    void modifyStorehouse(Storehouse storehouse);

    void deleteStorehouse(Storehouse storehouse);
}
