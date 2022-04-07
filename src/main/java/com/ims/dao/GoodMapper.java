package com.ims.dao;

import com.ims.domain.Good;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GoodMapper {
    void addGood(Good good);

    ArrayList<Good> selectGoodById(Integer id);

    ArrayList<Good> selectGoodByName(String name);

    ArrayList<Good> selectGoodByType(String type);

    ArrayList<Good> selectGoodByValue(Float value);

    ArrayList<Good> selectGoodMoreThan(Float value);

    ArrayList<Good> selectGoodLessThan(Float value);

    ArrayList<Good> selectAllGood();

    void modifyGood(Good good);

    void deleteGood(Good good);
}
