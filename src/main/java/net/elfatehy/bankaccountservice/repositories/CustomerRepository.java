package net.ZAKI.bankaccountservice.repositories;

import net.ZAKI.bankaccountservice.entities.BankAccount;
import net.ZAKI.bankaccountservice.entities.Customer;
import net.ZAKI.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
