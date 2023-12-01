package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void  signUp(Employee employee);

    public void saveBulkData(List<Employee> employeeList);

    public boolean signIn (String empEmailId,String empPassword);

    public Employee findById(int empId);

    public List<Employee> findAll();

    public List<Employee> findByContactNumber(long empcontactNumber);

    public List<Employee> findByName(String empName);

    public List<Employee> findByDob(String empDOB);

    public List<Employee> findByAnyInput(String anyinput);

    public List<Employee> sortById();

    public List<Employee> sortByName();

    public List<Employee> sortBySalary();

    public List<Employee> sortByDOB();

    public String LoanEligibility(int empId);

    public List<Employee> filterDataBySalary(int empSalary);

    public void updateById(Employee employee,int empId);

    public void deleteById(int empId);

    public void deleteAll();

}
