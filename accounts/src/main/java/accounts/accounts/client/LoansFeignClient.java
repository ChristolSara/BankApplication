package accounts.accounts.client;

import accounts.accounts.models.Cards;
import accounts.accounts.models.Customer;
import accounts.accounts.models.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {
    @RequestMapping(method = RequestMethod.POST,value = "myLoans",consumes = "application/json")
    List<Loans> getLoansDetails(@RequestBody Customer customer);
}
