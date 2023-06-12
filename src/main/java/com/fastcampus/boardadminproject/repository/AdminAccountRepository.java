package com.fastcampus.boardadminproject.repository;

import com.fastcampus.boardadminproject.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount, String> {
}
