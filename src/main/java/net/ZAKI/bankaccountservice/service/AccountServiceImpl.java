package net.ZAKI.bankaccountservice.service;

import jakarta.transaction.Transactional;
import net.ZAKI.bankaccountservice.dto.BankAccountRequestDto;
import net.ZAKI.bankaccountservice.dto.BankAccountResponseDto;
import net.ZAKI.bankaccountservice.entities.BankAccount;
import net.ZAKI.bankaccountservice.mappers.AccountMapper;
import net.ZAKI.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDto.getType())
                .balance(bankAccountDto.getBalance())
                .createdAt(new Date())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        /*BankAccountResponseDto bankAccountResponseDto = BankAccountResponseDto.builder()
                .id(saveBankAccount.getId())
                .type(saveBankAccount.getType())
                .balance(saveBankAccount.getBalance())
                .createdAt(saveBankAccount.getCreatedAt())
                .currency(saveBankAccount.getCurrency())
                .build();*/
        BankAccountResponseDto bankAccountResponseDto =  accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDto;
    }

    @Override
    public BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .type(bankAccountDto.getType())
                .balance(bankAccountDto.getBalance())
                .createdAt(new Date())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        /*BankAccountResponseDto bankAccountResponseDto = BankAccountResponseDto.builder()
                .id(saveBankAccount.getId())
                .type(saveBankAccount.getType())
                .balance(saveBankAccount.getBalance())
                .createdAt(saveBankAccount.getCreatedAt())
                .currency(saveBankAccount.getCurrency())
                .build();*/
        BankAccountResponseDto bankAccountResponseDto =  accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDto;
    }
}
