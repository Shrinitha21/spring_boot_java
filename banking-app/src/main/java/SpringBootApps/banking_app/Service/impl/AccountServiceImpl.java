package SpringBootApps.banking_app.Service.impl;

import SpringBootApps.banking_app.Entity.Account;
import SpringBootApps.banking_app.Repository.AccountRepository;
import SpringBootApps.banking_app.Service.AccountService;
import SpringBootApps.banking_app.dto.AccountDto;
import SpringBootApps.banking_app.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToEntity((accountDto));
        Account SavedAccount = accountRepository.save(account);

        return AccountMapper.mapToDto(SavedAccount);
    }

    @Override
    public AccountDto getAccountByID(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToDto(savedAccount);

    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient Balance");
        }
        double total = account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToDto(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToDto(account)).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);


    }

}
