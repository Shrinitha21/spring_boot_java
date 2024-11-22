package SpringBootApps.banking_app.Entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="accounts")
@Entity
public class Account {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double balance;


}
