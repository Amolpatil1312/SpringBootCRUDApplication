package com.csi.dao;


import com.csi.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void signUp(Customer customer) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();

    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        boolean flag = false;

        List<Customer> customers = session.createQuery("from Customer").list();

        for (Customer customer : customers){
            if(customer.getCustEmailId().equals(custEmailId)
            && customer.getCustPassword().equals(custPassword)){
                flag = true;
            }
        }


        return flag;
    }

    @Override
    public void savebulkData(List<Customer> custList) {

        Session session = factory.openSession();

        for(Customer customer :custList){

            Transaction transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();

        }

    }

    @Override
    public List<Customer> findAll() {
        Session session = factory.openSession();

        return session.createQuery("from Customer").list();
    }

    @Override
    public Customer findById(int custId) {
        Session session = factory.openSession();

        return (Customer) session.get(Customer.class,custId);
    }

    @Override
    public List<Customer> findByName(String custName) {
        return findAll().stream().filter(emp->emp.getCustName().equals(custName)).toList();
    }

    @Override
    public List<Customer> findByDOB(String CustDOB) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        List<Customer> customers = findAll().stream().filter(emp->dateFormat.format(emp.getCustDOB()).equals(CustDOB)).toList();

        return customers ;
    }

    @Override
    public List<Customer> findByGender(String custGender) {
        return findAll().stream().filter(emp->emp.getCustGender().equals(custGender)).toList();
    }

    @Override
    public List<Customer> findByEmailId(String custEmailId) {

        Session session = factory.openSession();

        return findAll().stream().filter(emp->emp.getCustEmailId().equals(custEmailId)).toList();
    }

    @Override
    public List<Customer> findByAnyInput(String anyInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


        return findAll().stream().filter(emp->dateFormat.format(emp.getCustDOB()).equals(anyInput)
        ||emp.getCustEmailId().equals(anyInput) || emp.getCustGender().equals(anyInput)
        ||emp.getCustName().equals(anyInput)).toList();
    }

    @Override
    public List<Customer> sortById() {
        return findAll().stream().sorted(Comparator.comparing(Customer::getCustId)).toList();
    }

    @Override
    public List<Customer> sortByName() {
        return findAll().stream().sorted(Comparator.comparing(Customer::getCustName)).toList();
    }

    @Override
    public List<Customer> sortByDOB() {
        return findAll().stream().sorted(Comparator.comparing(Customer::getCustDOB)).toList();
    }

    @Override
    public List<Customer> sortByGender() {
        return findAll().stream().sorted(Comparator.comparing(Customer::getCustGender)).toList();
    }

    @Override
    public List<Customer> sortBySalary() {
        return findAll().stream().sorted(Comparator.comparing(Customer::getCustSalary)).toList();
    }

    @Override
    public List<Customer> filterBySalary(int custSalary) {
        return findAll().stream().filter(emp->emp.getCustSalary()>=custSalary).toList();
    }

    @Override
    public void deleteById(int custId) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class,custId);

        session.delete(customer);

        transaction.commit();
    }

    @Override
    public void deleteAll() {

        Session session = factory.openSession();

        for(Customer customer : findAll()){

            Transaction transaction = session.beginTransaction();

            session.delete(customer);

            transaction.commit();
        }

    }
}
