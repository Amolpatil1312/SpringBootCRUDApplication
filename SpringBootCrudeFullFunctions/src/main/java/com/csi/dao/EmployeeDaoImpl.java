package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    @Override
    public void signUp(Employee employee) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();

    }

    @Override
    public void saveBulkData(List<Employee> employeeList) {

        Session session = factory.openSession();

        for(Employee employee : employeeList){

            Transaction transaction = session.beginTransaction();

            session.save(employee);

            transaction.commit();

        }



    }



    @Override
    public Employee findById(int empId) {

        Session session = factory.openSession();
        return (Employee) session.get(Employee.class,empId);
    }

    @Override
    public List<Employee> findAll() {

        Session session = factory.openSession();

        return session.createQuery("from Employee").list();
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        Session session = factory.openSession();

        boolean flag = false;

        for(Employee employee : findAll()){
            if(employee.getEmpEmailID().equals(empEmailId)
            && employee.getEmpPassword().equals(empPassword)){
                flag =true;
            }
        }


        return flag;
    }

    @Override
    public List<Employee> findByContactNumber(long empcontactNumber) {

        Session session = factory.openSession();

        List<Employee> employeeList = findAll().stream().filter(emp->emp.getEmpContactNumber()==empcontactNumber).toList();

        return employeeList;
    }

    @Override
    public List<Employee> findByName(String empName) {

        Session session = factory.openSession();

        List<Employee> employeeList = findAll().stream().filter(emp->emp.getEmpName().equals(empName)).toList();

        return employeeList;
    }

    @Override
    public List<Employee> findByDob(String empDOB) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Session session = factory.openSession();

        List<Employee> employeeList = findAll().stream().filter(emp-> dateFormat.format(emp.getEmpDOB()).equals(empDOB)).toList();

        return employeeList;
    }

    @Override
    public List<Employee> findByAnyInput(String anyinput) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Session session = factory.openSession();

        List<Employee> employeeList = findAll().stream().filter(emp->
        emp.getEmpName().equals(anyinput) || emp.getEmpAddress().equals(anyinput)
        || emp.getEmpPanCard().equals(anyinput) || emp.getEmpUID().equals(anyinput)
        || emp.getEmpGender().equals(anyinput)|| dateFormat.format(emp.getEmpDOB()).equals(anyinput)).toList();
        return employeeList;
    }

    @Override
    public List<Employee> sortById() {

        Session session = factory.openSession();

        return findAll().stream().sorted(Comparator.comparing(Employee::getEmpId)).toList();
    }

    @Override
    public List<Employee> sortByName() {

        Session session = factory.openSession();
        return findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).toList();
    }

    @Override
    public List<Employee> sortBySalary() {

        Session session = factory.openSession();
        return findAll().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).toList();
    }

    @Override
    public List<Employee> sortByDOB() {

        Session session = factory.openSession();
        return findAll().stream().sorted(Comparator.comparing(Employee::getEmpDOB)).toList();
    }

    @Override
    public String LoanEligibility(int empId) {

        Employee employee = findById(empId);

        String msg = "";

        if(employee.getEmpSalary()>=30000){
            msg = "Congratulations Your Eligible For Loan Please Apply with Mobile";
        }
        else {
            msg ="Your Not Eligible for The Loan..";
        }
        return msg;
    }

    @Override
    public List<Employee> filterDataBySalary(int empSalary) {

        return findAll().stream().filter(emp->emp.getEmpSalary()>=empSalary).toList();
    }

    @Override
    public void updateById(Employee employee,int empId) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee employee1 = findById(empId);

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpUID(employee.getEmpUID());
        employee1.setEmpGender(employee.getEmpGender());
        employee1.setEmpPanCard(employee.getEmpPanCard());
        employee1.setEmpEmailID(employee.getEmpEmailID());
        employee1.setEmpPassword(employee.getEmpPassword());

        session.update(employee1);

        transaction.commit();

    }

    @Override
    public void deleteById(int empId) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee employee = findById(empId);

        session.delete(employee);

        transaction.commit();

    }

    @Override
    public void deleteAll() {

        Session session = factory.openSession();

        for(Employee employee : findAll()){

            Transaction transaction = session.beginTransaction();

            session.delete(employee);

            transaction.commit();
        }

    }
}
