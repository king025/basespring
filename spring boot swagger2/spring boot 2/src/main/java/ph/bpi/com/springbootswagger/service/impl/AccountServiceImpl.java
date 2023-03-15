package ph.bpi.com.springbootswagger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ph.bpi.com.springbootswagger.dto.AccountDTO;
import ph.bpi.com.springbootswagger.entity.Account;
import ph.bpi.com.springbootswagger.repository.AccountRepository;
import ph.bpi.com.springbootswagger.service.AccountService;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok().body(accountRepository.findAll());
    }

    @Override
    public ResponseEntity<Account> createAccount(AccountDTO user){
        ModelMapper modelMapper = new ModelMapper();
        Account acc = modelMapper.map(user, Account.class);
        acc.setCreatedDate(new Date().toString());
        return ResponseEntity.ok().body(accountRepository.insert(acc));
    }
}
