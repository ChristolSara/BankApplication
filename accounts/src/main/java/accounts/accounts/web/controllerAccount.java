package accounts.accounts.web;

import accounts.accounts.models.Account;
import accounts.accounts.models.Customer;
import accounts.accounts.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class controllerAccount {

    private  AccountRepository accountRepository;

    @PostMapping("/myAccount")
    public List<Account> account(@RequestBody Customer customer){

        return accountRepository.findByCustomerId(customer.getCustomerId());
    }


    @GetMapping("/accounts")
    public List<Account> accountList(){
        return accountRepository.findAll();
    }
}
