package com.example.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CustomerTest {

    @Test
    public void AccountTest_isNotEmpty() {
        Customer cus = new Customer();
        cus.setId(23123);
        cus.setFirstName("Khen");
        cus.setLastName("Mao");

        Assertions.assertNotNull(cus.getId());
        Assertions.assertNotNull(cus.getFirstName());
        Assertions.assertNotNull(cus.getLastName());
    }

}
