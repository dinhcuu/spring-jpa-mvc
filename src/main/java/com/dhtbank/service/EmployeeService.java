package com.dhtbank.service;


import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    Iterable<Employee> findAll ();
    Employee  findById (Long id);
    boolean editEmployee ( Employee employee );
    boolean saveEmployee ( Employee employee );
    boolean deleteEmployee ( Employee employee );
    List<Employee> searchByCmt (String cmt);
    List<Employee> searchByName (String name);
}
