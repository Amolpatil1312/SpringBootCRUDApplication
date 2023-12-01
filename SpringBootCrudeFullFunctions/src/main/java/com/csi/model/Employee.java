package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    private String empName;

    private String empAddress;

    private double empSalary;

    private long empContactNumber;

    private String empPanCard;

    private String empUID;

    private  String empGender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date empDOB;

    private String empEmailID;

    private String empPassword;


}
