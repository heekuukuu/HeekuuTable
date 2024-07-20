package com.example.HeekuuTable.Service;

import com.example.HeekuuTable.model.Customer;
import com.example.HeekuuTable.model.SignUpForm;
import com.example.HeekuuTable.service.SignUpCustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class SignUpCustomerServiceTest {
    @Autowired
    private SignUpCustomerService service;

    @Test
    void signUp(){
         SignUpForm form = SignUpForm.builder()
                  .name("name")
                  .birth(LocalDate.now())
                  .email("abc@naver.com")
                  .password("1")
                  .phone("01064127697")
                  .build();
        Customer c = service.singUp(form);
        assertNotNull(c.getId());
        assertNotNull(c.getCratedAt());
    }

}