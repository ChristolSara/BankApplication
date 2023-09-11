package accounts.accounts.web;


import accounts.accounts.config.AccountsServiceConfig;
import accounts.accounts.models.Account;
import accounts.accounts.models.Customer;
import accounts.accounts.models.Properties;
import accounts.accounts.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class controllerAccount {



    private final AccountRepository accountRepository;
    private final AccountsServiceConfig accountsServiceConfig;

    public controllerAccount(AccountRepository accountRepository, AccountsServiceConfig accountsServiceConfig) {
        this.accountRepository = accountRepository;
        this.accountsServiceConfig = accountsServiceConfig;
    }

    @PostMapping("/myAccount")
    @ResponseBody
    public List<Account> account(@RequestBody Customer customer) {
        List<Account> accountList = accountRepository.findByCustomerId(customer.getCustomerId());
        if (accountList != null) {
            return accountList;
        } else {
            return null;
        }

    }


    @GetMapping("/accounts")
    public List<Account> accountList(){
        return (List<Account>) accountRepository.findAll();
    }



    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsServiceConfig.getMsg(),accountsServiceConfig.getBuildVersion(),
                accountsServiceConfig.getMailDetails(),accountsServiceConfig.getActiveBranches());

        String jsonStr = ow.writeValueAsString(properties);
        return  jsonStr;
    }
}
