package ph.bpi.com.springboot3swagger2.service;


import org.springframework.http.ResponseEntity;
import ph.bpi.com.springboot3swagger2.dto.AccountDTO;
import ph.bpi.com.springboot3swagger2.entity.Account;

import java.util.List;

public interface AccountService {

    ResponseEntity<List<Account>>  getAllAccounts();
    ResponseEntity<Account> createAccount(AccountDTO user);

}
