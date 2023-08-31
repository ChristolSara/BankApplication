package accounts.accounts.web;

import accounts.accounts.models.Account;
import accounts.accounts.models.Customer;
import accounts.accounts.repository.AccountRepository;
import accounts.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class controllerCustomer {

    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> customersList(){
        return customerRepository.findAll();
    }
}
