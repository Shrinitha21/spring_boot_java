package SpringBootApps.banking_app.Service;


import SpringBootApps.banking_app.Entity.Account;
import SpringBootApps.banking_app.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountByID(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void delete(Long id);
}
