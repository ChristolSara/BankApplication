package loans.loans.web;

import loans.loans.models.Customer;
import loans.loans.models.Loans;
import loans.loans.repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class loansController {

    private LoansRepository loansRepository;

    @PostMapping("/loansList")
    public List<Loans> loansList(@RequestBody Customer customer){


        return loansRepository.findAllByCustomerId(customer.getCustomerId());
    }

}
