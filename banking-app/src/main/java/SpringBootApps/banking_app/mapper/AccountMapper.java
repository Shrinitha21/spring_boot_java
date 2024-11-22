package SpringBootApps.banking_app.mapper;

import SpringBootApps.banking_app.Entity.Account;
import SpringBootApps.banking_app.dto.AccountDto;

public class AccountMapper {

    public static Account mapToEntity(AccountDto accountDto)
    {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()

        );
        return accountDto;
    }
}
