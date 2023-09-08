package accounts.accounts.models;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id
    @Column(name="account_number")
    private long accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_dt")
    private LocalDate createDt;


    @Column(name = "customer_id")
    private int customerId;
}
