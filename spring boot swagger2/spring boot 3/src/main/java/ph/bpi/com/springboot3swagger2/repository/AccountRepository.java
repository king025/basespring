package ph.bpi.com.springboot3swagger2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ph.bpi.com.springboot3swagger2.entity.Account;

@Repository
public interface AccountRepository  extends MongoRepository<Account, String> {
}
