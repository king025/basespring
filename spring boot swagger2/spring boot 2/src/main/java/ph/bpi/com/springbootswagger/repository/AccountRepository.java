package ph.bpi.com.springbootswagger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ph.bpi.com.springbootswagger.entity.Account;

@Repository
public interface AccountRepository  extends MongoRepository<Account, String> {
}
