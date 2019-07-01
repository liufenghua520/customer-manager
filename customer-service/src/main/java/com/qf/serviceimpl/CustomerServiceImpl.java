package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.CustomerMapper;
import com.qf.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int register(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Boolean loginCheck(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        List<Customer> customers = customerMapper.selectByMap(map);
        if (customers.get(0)!=null){
            return true;
        }
        return false;
    }
}
