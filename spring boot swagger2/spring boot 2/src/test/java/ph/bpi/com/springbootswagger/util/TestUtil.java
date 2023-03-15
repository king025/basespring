package ph.bpi.com.springbootswagger.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import ph.bpi.com.springbootswagger.dto.AccountDTO;
import ph.bpi.com.springbootswagger.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<Account> createAccountListForTesting() {
        List<Account> users = new ArrayList<>();
        users.add(user1());
        users.add(user2());
        return users;
    }

    public static Account user1() {
        Account acc1 = new Account();
        acc1.setId("MH-101");
        acc1.setName("Adelina");
        return acc1;
    }

    public static Account user2() {
        Account acc2 = new Account();
        acc2.setId("MH-102");
        acc2.setName("Karlo");
        return acc2;
    }

    public static AccountDTO userDto1() {
        AccountDTO acc1 = new AccountDTO();
        acc1.setName("Lyka");
        acc1.setAddress("Sampaloc 1");
        return acc1;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
