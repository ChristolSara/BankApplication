package accounts.accounts.models;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDetails {

    private  List<Account> accounts;
    private List<Loans> loans;
    private List<Cards> cards;
}
