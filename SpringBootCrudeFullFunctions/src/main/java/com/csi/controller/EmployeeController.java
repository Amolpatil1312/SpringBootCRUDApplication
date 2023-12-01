package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){
        employeeServiceImpl.signUp(employee);
        return ResponseEntity.ok("Data Saved Successfully");
    }

    @PostMapping("/saveall")
    public ResponseEntity<String> saveAll(@RequestBody List<Employee> emplist){
        employeeServiceImpl.saveBulkData(emplist);
        return ResponseEntity.ok("All Data  Saved Successfully");
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Employee> findById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.findById(empId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }

    @GetMapping("/findbycontactnumber/{empContact}")
    public ResponseEntity<List<Employee>> findByContactNumber(@PathVariable long empContact){
        return ResponseEntity.ok(employeeServiceImpl.findByContactNumber(empContact));
    }

    @GetMapping("/findbyname/{empName}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String empName){
        return  ResponseEntity.ok(employeeServiceImpl.findByName(empName));
    }

    @GetMapping("/findbydob/{empDob}")
    public ResponseEntity<List<Employee>> findByDOB(@PathVariable String empDob){
        return ResponseEntity.ok(employeeServiceImpl.findByDob(empDob));
    }

    @GetMapping("/findbyanyinput/{anyinput}")
    public ResponseEntity<List<Employee>> findByAnyInput(@PathVariable String anyinput ){
        return ResponseEntity.ok(employeeServiceImpl.findByAnyInput(anyinput));
    }
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortById(){
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByname(){
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBysalary(){
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }
    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB(){
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }
    @GetMapping("/loanelibility/{empId}")
    public ResponseEntity<String> loan(@PathVariable int empId,@RequestBody Employee employee){
        employeeServiceImpl.LoanEligibility(empId);
        String msg = "";
        if(employee.getEmpSalary()>=30000){
            msg = "Congratulations Your Eligible For Loan Please Apply with Mobile";
        }
        else {
            msg ="Your Not Eligible for The Loan..";
        }
        return ResponseEntity.ok(msg);
    }
    @GetMapping("filterbysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterBySalary(@PathVariable int empSalary){
        List<Employee> employeeList = employeeServiceImpl.filterDataBySalary(empSalary);
        return ResponseEntity.ok(employeeList);
    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<String> update(@RequestBody Employee employee,@PathVariable int empId){
        employeeServiceImpl.updateById(employee,empId);
        return ResponseEntity.ok("Data Updatet Successfully");
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deletall")
    public ResponseEntity<String> deleteAll(){
        employeeServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data Goan.....");
    }

}
