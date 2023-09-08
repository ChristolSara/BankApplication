package accounts.accounts.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int customerId;
    private String name;
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "create_dt")
    private LocalDate createDt;

}
