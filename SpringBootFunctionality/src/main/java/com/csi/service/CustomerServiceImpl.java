package com.csi.service;

import com.csi.dao.CustomerDao;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDao customerDaoImpl;
    @Override
    public void signUp(Customer customer) {
        customerDaoImpl.signUp(customer);

    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {
        return customerDaoImpl.signIn(custEmailId,custPassword);
    }

    @Override
    public void savebulkData(List<Customer> custList) {
        customerDaoImpl.savebulkData(custList);

    }

    @Override
    public List<Customer> findAll() {
        return customerDaoImpl.findAll();
    }

    @Override
    public Customer findById(int custId) {
        return customerDaoImpl.findById(custId);
    }

    @Override
    public List<Customer> findByName(String custName) {
        return customerDaoImpl.findByName(custName);
    }

    @Override
    public List<Customer> findByDOB(String CustDOB) {
        return customerDaoImpl.findByDOB(CustDOB);
    }

    @Override
    public List<Customer> findByGender(String custGender) {
        return customerDaoImpl.findByGender(custGender);
    }

    @Override
    public List<Customer> findByEmailId(String custEmailId) {
        return customerDaoImpl.findByEmailId(custEmailId);
    }

    @Override
    public List<Customer> findByAnyInput(String anyInput) {
        return customerDaoImpl.findByAnyInput(anyInput);
    }

    @Override
    public List<Customer> sortById() {
        return customerDaoImpl.sortById();
    }

    @Override
    public List<Customer> sortByName() {
        return customerDaoImpl.sortByName();
    }

    @Override
    public List<Customer> sortByDOB() {
        return customerDaoImpl.sortByDOB();
    }

    @Override
    public List<Customer> sortByGender() {
        return customerDaoImpl.sortByGender();
    }

    @Override
    public List<Customer> sortBySalary() {
        return customerDaoImpl.sortBySalary();
    }

    @Override
    public List<Customer> filterBySalary(int custSalary) {
        return customerDaoImpl.filterBySalary(custSalary);
    }

    @Override
    public void deleteById(int custId) {

        customerDaoImpl.deleteById(custId);
    }

    @Override
    public void deleteAll() {
        customerDaoImpl.deleteAll();

    }
}
