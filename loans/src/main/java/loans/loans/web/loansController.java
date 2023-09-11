package loans.loans.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import loans.loans.config.LoansServiceConfig;
import loans.loans.models.Customer;
import loans.loans.models.Loans;
import loans.loans.models.Properties;
import loans.loans.repository.LoansRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class loansController {

    private final LoansRepository loansRepository;

    private final LoansServiceConfig loansServiceConfig;

    public loansController(LoansRepository loansRepository, LoansServiceConfig loansServiceConfig) {
        this.loansRepository = loansRepository;
        this.loansServiceConfig = loansServiceConfig;
    }

    @PostMapping("/loansList")
    public List<Loans> loansList(@RequestBody Customer customer){
        return loansRepository.findAllByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansServiceConfig.getMsg(),loansServiceConfig.getBuildVersion(),
                loansServiceConfig.getMailDetails(),loansServiceConfig.getActiveBranches());

        String jsonStr = ow.writeValueAsString(properties);
        return  jsonStr;
    }

}
