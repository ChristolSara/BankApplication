package loans.loans.web;

import loans.loans.repository.LoansRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor @NoArgsConstructor
public class loansController {

    private LoansRepository loansRepository;
}
