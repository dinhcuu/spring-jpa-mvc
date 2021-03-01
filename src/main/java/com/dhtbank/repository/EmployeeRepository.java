package com.dhtbank.repository;

import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e where e.cmt = :cmt")
    List<Employee> searchByCmt(@Param("cmt") String cmt);

    @Query("select e from Employee e where e.ten like concat('%',:name,'%')")
    List<Employee> searchByName(@Param("name") String name);
}
