package com.qf.serviceimpl;

import com.qf.entity.Customer;

public interface CustomerService {

    int register(Customer customer);

    Boolean loginCheck(String username, String password);
}
