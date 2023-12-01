package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeDao employeeDaoImpl;
    @Override
    public void signUp(Employee employee) {
        employeeDaoImpl.signUp(employee);
    }

    @Override
    public void saveBulkData(List<Employee> employeeList) {
        employeeDaoImpl.saveBulkData(employeeList);

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }

    @Override
    public Employee findById(int empId) {
        return employeeDaoImpl.findById(empId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDaoImpl.findAll();
    }

    @Override
    public List<Employee> findByContactNumber(long empcontactNumber) {
        return employeeDaoImpl.findByContactNumber(empcontactNumber);
    }

    @Override
    public List<Employee> findByName(String empName) {
        return employeeDaoImpl.findByName(empName);
    }

    @Override
    public List<Employee> findByDob(String empDOB) {
        return employeeDaoImpl.findByDob(empDOB);
    }

    @Override
    public List<Employee> findByAnyInput(String anyinput) {
        return employeeDaoImpl.findByAnyInput(anyinput);
    }

    @Override
    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    @Override
    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    @Override
    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    @Override
    public String LoanEligibility(int empId) {
        return employeeDaoImpl.LoanEligibility(empId);
    }

    @Override
    public List<Employee> filterDataBySalary(int empSalary) {
        return employeeDaoImpl.filterDataBySalary(empSalary);
    }

    @Override
    public void updateById(Employee employee, int empId) {
        employeeDaoImpl.updateById(employee,empId);
    }

    @Override
    public void deleteById(int empId) {
        employeeDaoImpl.deleteById(empId);
    }

    @Override
    public void deleteAll() {
        employeeDaoImpl.deleteAll();
    }
}
