package net.elfatehy.bankaccountservice.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ZAKI.bankaccountservice.dto.BankAccountRequestDto;
import net.ZAKI.bankaccountservice.dto.BankAccountResponseDto;
import net.ZAKI.bankaccountservice.entities.BankAccount;
import net.ZAKI.bankaccountservice.entities.Customer;
import net.ZAKI.bankaccountservice.repositories.BankAccountRepository;
import net.ZAKI.bankaccountservice.repositories.CustomerRepository;
import net.ZAKI.bankaccountservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    private AccountService accountService;
    private BankAccountRepository bankAccountRepository;
    private CustomerRepository customerRepository;

    public BankAccountGraphQLController(AccountService accountService, BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        this.accountService = accountService;
        this.bankAccountRepository = bankAccountRepository;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDto updateAccount(@Argument String id,@Argument BankAccountRequestDto bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

}



