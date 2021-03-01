package com.dhtbank.service;


import com.dhtbank.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll ();
    Customer  findById (Long id);
    boolean editCustomer ( Customer customer );
    boolean saveCustomer ( Customer customer );
    boolean deleteCustomer ( Customer customer );
    List<Customer> searchByCmt (String cmt);
    List<Customer> searchByName (String name);
}
