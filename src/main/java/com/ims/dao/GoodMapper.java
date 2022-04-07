package com.ims.dao;

import com.ims.domain.Good;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodMapper {
    void addGood(Good good);

    List<Good> selectGoodById(Integer id);

    List<Good> selectGoodByName(String name);

    List<Good> selectGoodByType(String type);

    List<Good> selectGoodByValue(Float value);

    List<Good> selectGoodMoreThan(Float value);

    List<Good> selectGoodLessThan(Float value);

    List<Good> selectAllGood();

    void modifyGood(Good good);

    void deleteGood(Good good);
}
