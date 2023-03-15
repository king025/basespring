package ph.bpi.com.springboot3swagger2.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.bpi.com.springboot3swagger2.Springboot3Swagger2Application;
import ph.bpi.com.springboot3swagger2.entity.Account;
import ph.bpi.com.springboot3swagger2.repository.AccountRepository;
import ph.bpi.com.springboot3swagger2.util.TestUtil;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp() {

        Mockito.when(accountRepository.findAll())
                .thenReturn(TestUtil.createAccountListForTesting());

        Mockito.when(accountRepository.insert(Mockito.any(Account.class))).thenReturn(TestUtil.user1());
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = TestUtil.createAccountListForTesting();
        Mockito.when(accountRepository.findAll()).thenReturn(accounts);

        ResponseEntity<List<Account>> getAllResult = accountService.getAllAccounts();
        Assert.assertEquals(2, getAllResult.getBody().size());
        Assert.assertNotNull(getAllResult.getBody());
    }

    @Test
    public void createAccountTest() {

        ResponseEntity<Account> createdAcc = accountService.createAccount(TestUtil.userDto1());
        Assert.assertNotNull(createdAcc.getBody());
    }
}
