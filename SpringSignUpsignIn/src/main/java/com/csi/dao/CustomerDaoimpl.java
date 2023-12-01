package com.csi.dao;

import com.csi.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoimpl implements  CustomerDao {

   private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Customer customer) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();

    }

    @Override
    public boolean signIn(String custEmailId, String CustPassword) {
        boolean flag = false;
        Session session = factory.openSession();
        List<Customer> customers = session.createQuery("from Customer").list();
        for(Customer customer:customers){
            if(customer.getCustEmailId().equals(custEmailId)
            && customer.getCustPassword().equals(CustPassword)){
                flag =true;
                break;
            }
        }
        return flag;
    }
}
