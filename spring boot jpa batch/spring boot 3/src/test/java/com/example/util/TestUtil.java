package com.example.util;

import com.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<Customer> createCustomerListForTesting() {
        List<Customer> users = new ArrayList<>();
        users.add(user1());
        users.add(user2());
        users.add(user3());
        users.add(user4());
        return users;
    }

    public static Customer user1() {
        Customer cust1 = new Customer();
        cust1.setId(1331);
        cust1.setFirstName("John");
        cust1.setLastName("William");
        return cust1;
    }
    public static Customer user2() {
        Customer cust2 = new Customer();
        cust2.setId(4535);
        cust2.setFirstName("Jay");
        cust2.setLastName("Watson");
        return cust2;
    }
    public static Customer user3() {
        Customer cust3 = new Customer();
        cust3.setId(8792);
        cust3.setFirstName("Ryan");
        cust3.setLastName("Juan");
        return cust3;
    }
    public static Customer user4() {
        Customer cust4 = new Customer();
        cust4.setId(1237);
        cust4.setFirstName("Jake");
        cust4.setLastName("Merry");
        return cust4;
    }
}
