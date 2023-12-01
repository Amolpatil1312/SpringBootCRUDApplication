package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDaoimpl implements EmployeeDao{

   private static  SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void save(Employee employee) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> empList = new ArrayList<>();

        Session session = factory.openSession();

        empList = session.createQuery("from Employee").list();

        return empList;
    }

    @Override
    public Employee findById(int empid) {
        Session session = factory.openSession();

        return (Employee) session.get(Employee.class,empid);
    }

    @Override
    public void updateById(Employee employee, int empId) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee employee1 = findById(empId);

        employee1.setEmpName(employee.getEmpName());

        employee1.setEmpAddress(employee.getEmpAddress());

        employee1.setEmpContactNumber(employee.getEmpContactNumber());

        employee1.setEmpSalary(employee.getEmpSalary());

        employee1.setEmpEmailId(employee.getEmpEmailId());

        employee1.setEmpPassword(employee.getEmpPassword());

        session.update(employee1);

        transaction.commit();


    }

    @Override
    public void deleteById(int empId) {
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class,empId);

        session.delete(employee);

        transaction.commit();
    }

    @Override
    public void deleteAll() {
        List<Employee> empList = new ArrayList<>();

        Session session = factory.openSession();



        empList = session.createQuery("from Employee").list();

        for(Employee employee : empList){

            Transaction transaction = session.beginTransaction();
            session.delete(employee);

            transaction.commit();
        }



    }
}
