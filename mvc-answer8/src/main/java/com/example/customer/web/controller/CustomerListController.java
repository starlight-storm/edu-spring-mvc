package com.example.customer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.customer.business.domain.Customer;
import com.example.customer.business.service.CustomerService;

@Controller
public class CustomerListController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public String home() {
        return "forward:/customer";
    }
    
    private static int PAGE_SIZE = 3;
    
    @GetMapping(value = "/customer")
    public String showAllCustomers(@RequestParam(value = "page", defaultValue = "0") String page, Model model) {
        //List<Customer> customers = customerService.findAll();
        PagedListHolder<Customer> customers = new PagedListHolder<>(customerService.findAll());
        customers.setPage(Integer.parseInt(page));
        customers.setPageSize(PAGE_SIZE);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping(value = "/customer/{customerId}")
    public String showCustomerDetail(@PathVariable int customerId, Model model) {
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }
}
