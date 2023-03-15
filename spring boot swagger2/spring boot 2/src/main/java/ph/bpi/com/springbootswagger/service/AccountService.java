package ph.bpi.com.springbootswagger.service;

import org.springframework.http.ResponseEntity;
import ph.bpi.com.springbootswagger.dto.AccountDTO;
import ph.bpi.com.springbootswagger.entity.Account;

import java.util.List;

public interface AccountService {

    ResponseEntity<List<Account>>  getAllAccounts();
    ResponseEntity<Account> createAccount(AccountDTO user);
}
