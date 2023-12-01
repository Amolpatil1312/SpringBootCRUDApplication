package com.csi.services;

import com.csi.model.Customer;

public interface CustomerServices {

    public void signUp(Customer customer);

    public boolean signIn(String custEmailId,String CustPassword);

}
