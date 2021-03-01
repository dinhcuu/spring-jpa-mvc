package com.dhtbank.repository;


import com.dhtbank.model.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c where c.cmt = :cmt")
    List<Customer> searchByCmt(@Param("cmt") String cmt);

    @Query("select c from Customer c where c.ten like concat('%',:name,'%')")
    List<Customer> searchByName(@Param("name") String name);
}
