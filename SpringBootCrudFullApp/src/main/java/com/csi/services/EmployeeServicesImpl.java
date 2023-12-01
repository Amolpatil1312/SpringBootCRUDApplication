package com.csi.services;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements  EmployeeServices{

    @Autowired
    EmployeeDao employeeDaoImpl;
    @Override
    public void save(Employee employee) {
        employeeDaoImpl.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDaoImpl.findAll();
    }

    @Override
    public Employee findById(int empId) {
        return employeeDaoImpl.findById(empId);
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
