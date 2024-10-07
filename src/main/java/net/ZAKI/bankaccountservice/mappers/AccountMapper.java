package net.ZAKI.bankaccountservice.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import net.ZAKI.bankaccountservice.dto.BankAccountResponseDto;
import net.ZAKI.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDto);
        return bankAccountResponseDto;
    }
}
