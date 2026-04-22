package com.example.rpgTest01.model;


import lombok.Data;
import java.time.LocalDate;

@Data
public class Customer {
    private Long custId;
    private String custName;
    private String address;
    private String city;
    private String phone;
    private String email;
    private String status ="A";
    private LocalDate createDate;
}