package com.ims.common.service.Interface;

import com.ims.domain.Good;

import java.util.List;


public interface GoodManagement {
    String addGood(Good good);

    String selectGoodById(Integer id);

    String selectGoodByName(String name, Integer offset, Integer limit);

    String selectGoodByType(String type, Integer offset, Integer limit);

    String selectGoodByValue(Float value, Integer offset, Integer limit);

    String selectGoodMoreThan(Float value, Integer offset, Integer limit);

    String selectGoodLessThan(Float value, Integer offset, Integer limit);

    String selectAllGood(Integer offset, Integer limit);

    String selectCommon(List<Good> goods);

    String modifyGood(Good good);

    String deleteGood(Good good);
}