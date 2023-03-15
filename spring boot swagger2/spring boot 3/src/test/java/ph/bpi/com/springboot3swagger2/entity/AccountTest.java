package ph.bpi.com.springboot3swagger2.entity;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void AccountTest_isNotEmpty() {
        Account acc = new Account();

        acc.setId("0134334");
        acc.setName("Karla");
        acc.setNumber("#343434");
        acc.setAddress("1445 Sampaloc");
        acc.setCreatedBy("tester 1");
        acc.setCreatedDate("2022-01");
        acc.setUpdatedBy("tester 2");
        acc.setUpdatedDate("2022-12");

        Assert.assertNotNull(acc.getId());
        Assert.assertNotNull(acc.getName());
        Assert.assertNotNull(acc.getNumber());
        Assert.assertNotNull(acc.getAddress());
        Assert.assertNotNull(acc.getCreatedBy());
        Assert.assertNotNull(acc.getCreatedDate());
        Assert.assertNotNull(acc.getUpdatedBy());
        Assert.assertNotNull(acc.getUpdatedDate());
    }
}
