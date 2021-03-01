package com.dhtbank.controller;

import com.dhtbank.model.Customer;
import com.dhtbank.model.Employee;
import com.dhtbank.model.TKTinDung;
import com.dhtbank.service.CustomerService;
import com.dhtbank.service.EmployeeService;
import com.dhtbank.service.TKGuiService;
import com.dhtbank.service.TKTinDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class AdminController {

    private final EmployeeService employeeService;
    private final CustomerService customerService;
    private final TKTinDungService tkTinDungService;
    private final TKGuiService tkGuiService;

    @Autowired
    public AdminController(EmployeeService employeeService, CustomerService customerService, TKTinDungService tkTinDungService, TKGuiService tkGuiService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.tkTinDungService = tkTinDungService;
        this.tkGuiService = tkGuiService;
    }

    @GetMapping(value = "/admin/home")
    public String getAdminHomePage() {
        return "admin/admin-home";
    }

    //Manage employee
    //Go to manage employee page
    @GetMapping(value = "/admin/manage-staff")
    public String getManageStaffPage(Model model) {
        ArrayList<Employee> employeeList = (ArrayList<Employee>) employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "admin/admin-manage-info-staff";
    }

    //Create staff
    @GetMapping(value = "/admin/create-employee")
    public String createEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "admin/admin-create-info-employee";
    }

    @PostMapping(value = "/admin/create-employee")
    public String createEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("role") String role, Model model) {
        employee.setViTri(role);
        employee.setMa("NV" + employee.getCmt());
        employeeService.saveEmployee(employee);
        model.addAttribute("employee", employee);
        return "admin/admin-show-info-employee";
    }

    //Edit Employee
    @GetMapping(value = "/admin/edit-employee")
    public String editEmployee(Model model, @RequestParam(value = "id") int index) {
        ArrayList<Employee> employees = (ArrayList<Employee>) employeeService.findAll();
        Employee employee = employees.get(index);
        model.addAttribute("employee", employee);
        return "admin/admin-edit-info-employee";
    }

    @PostMapping(value = "/admin/edit-employee")
    public String editEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("role") String role) {
        employee.setViTri(role);
        Employee employee1 = employeeService.findById(employee.getId());
        employee.setNgayTao(employee1.getNgayTao());
        employeeService.saveEmployee(employee);
        return "admin/admin-show-info-employee";
    }

    //Delete employee
    @GetMapping(value = "/admin/delete-employee")
    public String deleteEmployee(@ModelAttribute("id") int index) {
        ArrayList<Employee> employees = (ArrayList<Employee>) employeeService.findAll();
        employeeService.deleteEmployee(employees.get(index));
        return "redirect:/admin/manage-staff";
    }

    //Search employee
    @PostMapping(value = "/admin/search-employee")
    public String searchStaffByKey(Model model, @RequestParam("key") String key, @RequestParam("searchBy") String searchBy) {
        if (searchBy.equals("NAME")) {
            ArrayList<Employee> employees = (ArrayList<Employee>) employeeService.searchByName(key);
            model.addAttribute("employees", employees);
        } else if (searchBy.equals("CMT")) {
            ArrayList<Employee> employees = (ArrayList<Employee>) employeeService.searchByCmt(key);
            model.addAttribute("employees", employees);
        }
        return "admin/admin-manage-info-staff";
    }

    //Manage Customer
    //Đi đến trang chủ quản lý thông tin khách hàng
    @GetMapping(value = "/admin/manage-customer")
    public String getManageCustomerPage(Model model) {
        ArrayList<Customer> customers = (ArrayList<Customer>) customerService.findAll();
        model.addAttribute("customers", customers);
        return "admin/admin-manage-info-customer";
    }

    //Thêm khách hàng
    @GetMapping(value = "/admin/create-customer")
    public String createCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "admin/admin-create-info-customer";
    }

    @PostMapping(value = "/admin/create-customer")
    public String createCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        customer.setMa("KH" + customer.getCmt());
        customerService.saveCustomer(customer);
        model.addAttribute("customer", customer);
        return "admin/admin-show-info-customer";
    }

    //Sửa thông tin khách hàng
    @GetMapping(value = "/admin/edit-customer")
    public String editCustomer(Model model, @RequestParam(value = "id") int index) {
        ArrayList<Customer> customers = (ArrayList<Customer>) customerService.findAll();
        Customer customer = customers.get(index);
        model.addAttribute("customer", customer);
        return "admin/admin-edit-info-customer";
    }

    @PostMapping(value = "/admin/edit-customer")
    public String editCustomer(@ModelAttribute("customer") Customer customer) {
        Customer customer1 = customerService.findById(customer.getId());
        customer.setNgayTao(customer1.getNgayTao());
        customerService.saveCustomer(customer);
        return "admin/admin-show-info-customer";
    }

    //Search customer
    @PostMapping(value = "/admin/search-customer")
    public String searchCustomerByKey(Model model, @RequestParam("key") String key, @RequestParam("searchBy") String searchBy) {
        if (searchBy.equals("NAME")) {
            ArrayList<Customer> customers = (ArrayList<Customer>) customerService.searchByName(key);
            model.addAttribute("customers", customers);
        } else if (searchBy.equals("CMT")) {
            ArrayList<Customer> customers = (ArrayList<Customer>) customerService.searchByCmt(key);
            model.addAttribute("customers", customers);
        }
        return "admin/admin-manage-info-customer";
    }

    //Delete customer
    @GetMapping(value = "/admin/delete-customer")
    public String deleteCustomer(@RequestParam("id") int index) {
        ArrayList<Customer> customers = (ArrayList<Customer>) customerService.findAll();
        customerService.deleteCustomer(customers.get(index));
        return "redirect:/admin/manage-customer";
    }

    //Manage Tai Khoan Gui
    @GetMapping(value = "/admin/manage-TKGui")
    public String getManageTKGuiPage(Model model) {
        ArrayList<Customer> customers = new ArrayList<>();
        model.addAttribute("customers", customers);
        return "admin/admin-manage-info-TKGui";
    }

    //Manage Tai Khoan Tin Dung
    //Trang chính TK Tín DỤng
    @GetMapping(value = "/admin/manage-TKTinDung")
    public String getManageTKTinDungPage(Model model) {
        ArrayList<Customer> customers = new ArrayList<>();
        model.addAttribute("customers", customers);
        return "admin/admin-manage-info-TKTinDung";
    }

    @PostMapping(value = "/admin/manage-TKTinDung")
    public String getManageTKTinDung(Model model, @RequestParam("key") String key, @RequestParam("searchBy") String searchBy) {
        if (searchBy.equals("NAME")) {
            ArrayList<Customer> customers = (ArrayList<Customer>) customerService.searchByName(key);
            model.addAttribute("customers", customers);
        } else if (searchBy.equals("CMT")) {
            ArrayList<Customer> customers = (ArrayList<Customer>) customerService.searchByCmt(key);
            model.addAttribute("customers", customers);
        }
        return "admin/admin-manage-info-TKTinDung";
    }

    //Hiển thị tất cả tài khoản tín dụng của khách hàng
    @GetMapping(value = "/admin/show-tktindungs")
    public String getTinDungs(@RequestParam("id") int index, Model model) {
        ArrayList<Customer> customers = (ArrayList<Customer>) customerService.findAll();
        Customer customer = customers.get(index);
        model.addAttribute("tktindungs", customer.getTkTinDungs());
        return "admin/admin-show-all-TKTinDungCustomer";
    }
    //Edit tk tín dụng
    @GetMapping(value = "/admin/edit-tktindung")
    public String editTKTinDung(@RequestParam("id") Long id, Model model) {
        TKTinDung tkTinDung = tkTinDungService.findById(id);
        model.addAttribute("tktindung", tkTinDung);
        return "admin/admin-edit-info-TKTinDung";
    }
    @PostMapping(value = "/admin/edit-tktindung")
    public String editTKTinDung(@ModelAttribute("tktindung") TKTinDung tkTinDung, Model model) {
        TKTinDung tkTinDung1 = tkTinDungService.findById(tkTinDung.getId());
        tkTinDung.setNgayTao(tkTinDung1.getNgayTao());
        tkTinDung.setCustomer(tkTinDung1.getCustomer());
        tkTinDung.setEmployee(tkTinDung1.getEmployee());
        tkTinDungService.saveTKTinDung(tkTinDung);
        model.addAttribute("tktindung", tkTinDung);
        return "admin/admin-show-info-TKTinDung";
    }
    //Delete tk tin dung
    @GetMapping(value = "/admin/delete-tktindung")
    public String deleteTKTinDung(@RequestParam("id") Long id) {
        tkTinDungService.deleteTKTinDung(tkTinDungService.findById(id));
        return "admin/admin-show-all-TKTinDungCustomer";
    }
}
