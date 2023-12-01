package com.csi.dao;

import com.csi.model.Customer;

import java.util.List;

public interface CustomerDao {

    public void signUp(Customer customer);

    public boolean signIn(String custEmailId,String custPassword);

    public void savebulkData(List<Customer> custList);

    public List<Customer> findAll();

    public Customer findById(int custId);

    public List<Customer> findByName(String custName);

    public List<Customer> findByDOB(String CustDOB);

    public List<Customer> findByGender(String custGender);

    public List<Customer> findByEmailId(String custEmailId);

    public List<Customer> findByAnyInput(String anyInput);

    public List<Customer> sortById();

    public List<Customer> sortByName();

    public List<Customer> sortByDOB();

    public List<Customer> sortByGender();

    public List<Customer> sortBySalary();

    public List<Customer> filterBySalary(int custSalary);

    public void deleteById(int custId);

    public void deleteAll();




}
