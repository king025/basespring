package com.example.Batch;

import com.example.batch.BatchConfig;
import com.example.model.Customer;
import com.example.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BatchConfigTest {

    @Autowired
    private BatchConfig batchConfig;

    @Test
    public void getFileReaderTest() throws Exception {
        batchConfig.reader().open(new ExecutionContext());
        Customer cust=null;
        int i=0;
        for(Customer c : TestUtil.createCustomerListForTesting()){
            batchConfig.reader().setCurrentItemCount(i);
            cust = batchConfig.reader().read();
            Assert.assertEquals(c.getFirstName(),cust.getFirstName());
            Assert.assertEquals(c.getLastName(),cust.getLastName());
            i++;
        }
    }
}
