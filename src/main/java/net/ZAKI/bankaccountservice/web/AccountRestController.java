package net.ZAKI.bankaccountservice.web;

import net.ZAKI.bankaccountservice.dto.BankAccountRequestDto;
import net.ZAKI.bankaccountservice.dto.BankAccountResponseDto;
import net.ZAKI.bankaccountservice.entities.BankAccount;
import net.ZAKI.bankaccountservice.mappers.AccountMapper;
import net.ZAKI.bankaccountservice.repositories.BankAccountRepository;
import net.ZAKI.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {


    private BankAccountRepository bankAccountRepository;

    private AccountService accountService;

    private AccountMapper accountMapper;


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Bank account not found",id)));
    }


    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto bankAccountRequestDto){
        return accountService.addAccount(bankAccountRequestDto);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id ,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
