package accounts.accounts.web;

import accounts.accounts.config.AccountsServiceConfig;
import accounts.accounts.models.Account;
import accounts.accounts.models.Customer;
import accounts.accounts.models.Properties;
import accounts.accounts.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController @AllArgsConstructor @NoArgsConstructor
public class controllerAccount {

    private  AccountRepository accountRepository;
    @Autowired
    AccountsServiceConfig accountsServiceConfig;

    @PostMapping("/myAccount")
    public List<Account> account(@RequestBody Customer customer){

        return accountRepository.findByCustomerId(customer.getCustomerId());
    }


    @GetMapping("/accounts")
    public List<Account> accountList(){
        return accountRepository.findAll();
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
