package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int custId;

    @Column(name = "Name")
    private String custName;

    @Column(name = "Address")
    private String custAddress;

    @Column(name = "Salary")
    private double custSalary;

    @Column(name = "Contact")
    private long custContactNumber;

    @Column(name = "Email")
    private String custEmailId;

    @Column(name = "Password")
    private String custPassword;


}
