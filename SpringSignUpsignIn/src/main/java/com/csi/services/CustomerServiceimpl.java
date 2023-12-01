package com.csi.services;

import com.csi.dao.CustomerDao;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl implements  CustomerServices{
    @Autowired
    CustomerDao customerDaoimpl;
    @Override
    public void signUp(Customer customer) {
        customerDaoimpl.signUp(customer);
    }

    @Override
    public boolean signIn(String custEmailId, String CustPassword) {
        return customerDaoimpl.signIn(custEmailId,CustPassword);
    }
}
