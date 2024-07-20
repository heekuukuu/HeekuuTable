package com.example.HeekuuTable.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SignUpForm {

    private String email;
    private String name;
    private String password;
    private String phone;
    private LocalDate birth;


}