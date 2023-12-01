package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Customer customer){
        customerServiceImpl.signUp(customer);
        return ResponseEntity.ok("SignUP Done Successfully..");
    }

    @PostMapping("/savealldata")
    public ResponseEntity<String> saveall(@PathVariable List<Customer> customers){
        customerServiceImpl.savebulkData(customers);
        return ResponseEntity.ok("All Data Saved Successfully..");
    }

    @PostMapping("/signin/{custemailid}/{custpassword}")
    public ResponseEntity<String> signIn(@PathVariable String custemailid,@PathVariable String custpassword){
        customerServiceImpl.signIn(custemailid,custpassword);
        return ResponseEntity.ok("SignIn Done Successfully...");
    }
    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Customer> findById(@PathVariable int custId){

        return ResponseEntity.ok(customerServiceImpl.findById(custId));
    }

    @GetMapping("/findbyname/{custName}")
    public ResponseEntity<List<Customer>> findById(@PathVariable String custName){

        return ResponseEntity.ok(customerServiceImpl.findByName(custName));
    }

    @GetMapping("/findbydob/{custDOB}")
    public ResponseEntity<List<Customer>> findBydob(@PathVariable String custDOB){

        return ResponseEntity.ok(customerServiceImpl.findByDOB(custDOB));
    }

    @GetMapping("/findbygender/{custGender}")
    public ResponseEntity<List<Customer>> findByGender(@PathVariable String custGender){

        return ResponseEntity.ok(customerServiceImpl.findByGender(custGender));
    }


    @GetMapping("/findbyemail/{custEmail}")
    public ResponseEntity<List<Customer>> findByEmail(@PathVariable String custEmail){

        return ResponseEntity.ok(customerServiceImpl.findByEmailId(custEmail));
    }

    @GetMapping("/findbyanyinput/{anyinput}")
    public ResponseEntity<List<Customer>> findByAnyInput(@PathVariable String anyinput){

        return ResponseEntity.ok(customerServiceImpl.findByAnyInput(anyinput));
    }
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Customer>> sortById(){
        return ResponseEntity.ok(customerServiceImpl.sortById());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName(){
        return ResponseEntity.ok(customerServiceImpl.sortByName());
    }

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Customer>> sortByDOB(){
        return ResponseEntity.ok(customerServiceImpl.sortByDOB());
    }

    @GetMapping("/sortbygender")
    public ResponseEntity<List<Customer>> sortByGender(){
        return ResponseEntity.ok(customerServiceImpl.sortByGender());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Customer>> sortBySalary(){
        return ResponseEntity.ok(customerServiceImpl.sortBySalary());
    }

    @GetMapping("/filterbysalary/{custSalary}")
    public ResponseEntity<List<Customer>> filterBySalary(@PathVariable int custSalary){
        return ResponseEntity.ok(customerServiceImpl.filterBySalary(custSalary));
    }


    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId){
        customerServiceImpl.deleteById(custId);
        return  ResponseEntity.ok("Data Deleted Successfully");
    }
    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        customerServiceImpl.deleteAll();
        return ResponseEntity.ok("All data Deleted Successfully...");
    }


}
