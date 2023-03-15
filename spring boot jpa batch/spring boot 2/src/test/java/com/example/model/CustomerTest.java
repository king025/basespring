package com.example.model;


import org.junit.Assert;
import org.junit.Test;
public class CustomerTest {

    @Test
    public void AccountTest_isNotEmpty() {
        Customer cus = new Customer();
        cus.setId(23123);
        cus.setFirstName("Khen");
        cus.setLastName("Mao");

        Assert.assertNotNull(cus.getId());
        Assert.assertNotNull(cus.getFirstName());
        Assert.assertNotNull(cus.getLastName());
    }

}
