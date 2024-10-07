package net.ZAKI.bankaccountservice.service;

import net.ZAKI.bankaccountservice.dto.BankAccountRequestDto;
import net.ZAKI.bankaccountservice.dto.BankAccountResponseDto;
import net.ZAKI.bankaccountservice.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);

    BankAccountResponseDto updateAccount(String id, BankAccountRequestDto bankAccountDto);
}
