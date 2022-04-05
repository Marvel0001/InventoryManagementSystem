package com.ims.dao;

import com.ims.domain.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierMapper {
    void addSupplier(Supplier supplier);

    List<Supplier> selectSupplierById(Integer id);

    List<Supplier> selectSupplierByCompany(String company);

    List<Supplier> selectSupplierByPerson(String person);

    List<Supplier> selectAllSupplier();

    void modifySupplier(Supplier supplier);

    void deleteSupplier(Supplier supplier);
}
