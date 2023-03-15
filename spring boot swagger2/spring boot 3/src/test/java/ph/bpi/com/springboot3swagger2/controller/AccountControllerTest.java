package ph.bpi.com.springboot3swagger2.controller;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ph.bpi.com.springboot3swagger2.dto.AccountDTO;
import ph.bpi.com.springboot3swagger2.entity.Account;
import ph.bpi.com.springboot3swagger2.service.AccountService;
import ph.bpi.com.springboot3swagger2.util.TestUtil;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void getAllAccountTest()
            throws Exception {

        List<Account> accounts = TestUtil.createAccountListForTesting();
        ResponseEntity<List<Account>> users = ResponseEntity.ok().body(accounts);

        when(accountService.getAllAccounts()).thenReturn(users);

        mockMvc.perform(get("/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andDo(print());
    }

    @Test
    public void createAccountTest()
            throws Exception {

        Account acc1 = TestUtil.user1();
        String json = TestUtil.asJsonString(TestUtil.user2());

        ResponseEntity<Account> user = ResponseEntity.ok().body(acc1);
        when(accountService.createAccount(Mockito.any(AccountDTO.class))).thenReturn(user);

        RequestBuilder request = MockMvcRequestBuilders.post("/v1/accounts")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(TestUtil.user1().getName())))
                .andDo(print());
    }
}
