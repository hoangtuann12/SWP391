package com.example.SWP391.Respository;

import com.example.SWP391.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByEmail(String email);
    Account findByEmail(String email);
}
