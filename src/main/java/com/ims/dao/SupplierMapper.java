package com.ims.dao;

import com.ims.domain.Supplier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SupplierMapper {
    void addSupplier(Supplier supplier);

    ArrayList<String> selectAllSupplierName();

    ArrayList<Supplier> selectSupplierById(Integer id);

    ArrayList<Supplier> selectSupplierByCompany(String company);

    ArrayList<Supplier> selectSupplierByPerson(String person);

    ArrayList<Supplier> selectAllSupplier();

    void modifySupplier(Supplier supplier);

    void deleteSupplier(Supplier supplier);
}
