package com.dhtbank;

import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.service.CustomerService;
import com.dhtbank.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(scanBasePackages = "com.dhtbank")
public class DhtbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhtbankApplication.class, args);

//        ApplicationContext applicationContext = SpringApplication.run(DhtbankApplication.class, args);
//        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
//        Employee employee = new Employee();
//        employee.setMa("NV1");
//        employee.setCmt("12345678");
//        employee.setDiaChi("Ha Noi");
//        employee.setTen("Nguyen Van Hanh");
//        employee.setBacNghe(1);
//        employee.setThamNien(1);
//        employee.setNgaySinh("12/09/1998");
//        employee.setViTri("Manager");
//        employeeService.saveEmployee(employee);

//        ApplicationContext applicationContext = SpringApplication.run(DhtbankApplication.class, args);
//        CustomerService customerService = applicationContext.getBean(CustomerService.class);
//        Customer customer = new Customer();
//        customer.setMa("KH2");
//        customer.setCmt("12345670");
//        customer.setDiaChi("Ha Noi");
//        customer.setTen("Nguyen Van Dinh");
//        customer.setNgaySinh("12/09/1998");
//        customerService.saveCustomer(customer);
    }

}
