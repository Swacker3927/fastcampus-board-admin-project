package com.fastcampus.boardadminproject.repository;

import com.fastcampus.boardadminproject.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
