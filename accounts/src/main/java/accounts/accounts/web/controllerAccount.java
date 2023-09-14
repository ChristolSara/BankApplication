package accounts.accounts.web;


import accounts.accounts.client.CardsFeignClient;
import accounts.accounts.client.LoansFeignClient;
import accounts.accounts.config.AccountsServiceConfig;
import accounts.accounts.models.*;
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

    private final LoansFeignClient loansFeignClient;
    private final CardsFeignClient cardsFeignClient;

    public controllerAccount(AccountRepository accountRepository, AccountsServiceConfig accountsServiceConfig, LoansFeignClient loansFeignClient, CardsFeignClient cardsFeignClient) {
        this.accountRepository = accountRepository;
        this.accountsServiceConfig = accountsServiceConfig;
        this.loansFeignClient = loansFeignClient;
        this.cardsFeignClient = cardsFeignClient;
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


    @PostMapping("/myCustomerDetails")
    public CustomerDetails myCustomerDetails(@RequestBody Customer customer){
        List<Account> accounts =accountRepository.findByCustomerId(customer.getCustomerId());
        List<Cards> Cards = cardsFeignClient.getCardsDetails(customer);
        List<Loans> Loans = loansFeignClient.getLoansDetails(customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoans(Loans);
        customerDetails.setCards(Cards);

        return  customerDetails;
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
