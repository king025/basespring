package ph.bpi.com.springboot3swagger2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.bpi.com.springboot3swagger2.dto.AccountDTO;
import ph.bpi.com.springboot3swagger2.entity.Account;
import ph.bpi.com.springboot3swagger2.service.AccountService;


import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // List all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Create New Account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO user) {
        return accountService.createAccount(user);
    }

}
