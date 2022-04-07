package com.ims.common.service.Interface;

import com.ims.domain.Supplier;

import java.util.List;

public interface SupplierManagement {
    String addSupplier(Supplier Supplier);

    String selectCommon(List<Supplier> Suppliers);

    String selectSupplierById(Integer id);

    String selectSupplierByCompany(String company, Integer offset, Integer limit);

    String selectSupplierByPerson(String person, Integer offset, Integer limit);

    String selectAllSupplier(Integer offset, Integer limit);

    String modifySupplier(Supplier supplier);

    String deleteSupplier(Supplier supplier);
}
