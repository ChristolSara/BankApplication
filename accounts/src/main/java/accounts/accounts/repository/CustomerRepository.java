package accounts.accounts.repository;

import accounts.accounts.models.Account;
import accounts.accounts.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
