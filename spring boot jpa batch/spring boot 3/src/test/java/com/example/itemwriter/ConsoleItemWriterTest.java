package com.example.itemwriter;

import com.example.model.Customer;
import com.example.util.TestUtil;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConsoleItemWriterTest {

    @Autowired
    private ConsoleItemWriter<Customer> consoleItemWriter;

    @Test
    @Order(1)
    public void saveTest(){
        Iterable<Customer> cList =consoleItemWriter.saveAllData(TestUtil.createCustomerListForTesting());
        List<Customer> actualList = StreamSupport
                .stream(cList.spliterator(), false)
                .collect(Collectors.toList());
        Assertions.assertTrue(actualList.size()>0);
    }

    @Test
    @Order(2)
    public void searchTest() throws Exception {
        List<Customer> expectedList = consoleItemWriter.getAllData();
        Assertions.assertTrue(expectedList.size()>0);
    }

    @Test
    @Order(3)
    public void searchFirstNameTest() throws Exception {
        List<Customer> expectedList = consoleItemWriter.getFirstNameData("Jay");

        List<Customer> expected = expectedList.stream().filter(s-> s.getFirstName().equals("Jay")).collect(Collectors.toList());
        Assertions.assertTrue(expected.size()>0);
    }

    @Test
    @Order(4)
    public void searchLastNameTest() throws Exception {
        List<Customer> expectedList = consoleItemWriter.getLastNameData("William");

        List<Customer> expected = expectedList.stream().filter(s-> s.getLastName().equals("William")).collect(Collectors.toList());
        Assertions.assertTrue(expected.size()>0);
    }

}
