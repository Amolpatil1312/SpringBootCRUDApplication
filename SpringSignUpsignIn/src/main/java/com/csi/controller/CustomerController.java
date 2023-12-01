package com.csi.controller;

import com.csi.model.Customer;
import com.csi.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/amolapp")
public class CustomerController {
    @Autowired
    CustomerServices customerServicesimpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Customer customer){
        customerServicesimpl.signUp(customer);

        return ResponseEntity.ok("SignUp Done successfully..!");
    }

    @GetMapping("/signin/{custEmailId}/{CustPassword}")

    public ResponseEntity<String> SignIn(@PathVariable String custEmailId,@PathVariable String CustPassword ){
        String msg = "";
        if(customerServicesimpl.signIn(custEmailId,CustPassword)){
            msg = "Sign In Done Successfully";
        }else {
            msg = "oppp...invalid Creandintials...please Try Again....";
        }
        return  ResponseEntity.ok(msg);

    }




}
