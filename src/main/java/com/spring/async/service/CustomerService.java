package com.spring.async.service;


import com.spring.async.model.Customer;
import com.spring.async.repo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public List<Customer> getCustomerByName(String name) {
        log.info("Getting customer {} from the repository.", name);

        List<Customer> customerList = customerRepository.findByName(name);

        if (CollectionUtils.isEmpty(customerList)) {
            log.info("No customer found by name {}", name);
            return new ArrayList<>();
        }
        log.info("found {} customers by name {}", customerList.size(), name);
        return customerList;
    }

    public Customer addCustomer(Customer customer) {
        log.info("Adding customer {} to database", customer.getName());
        Customer newCustomer = customerRepository.save(customer);
        log.info("Added customer {} successfully", newCustomer.getName());
        return newCustomer;
    }
}