package com.fastcampus.boardadminproject.controller;

import com.fastcampus.boardadminproject.dto.response.AdminAccountResponse;
import com.fastcampus.boardadminproject.service.AdminAccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin/members")
@Controller
public class AdminAccountController {

    private final AdminAccountService adminAccountService;

    @GetMapping
    public String members() {
        return "admin/members";
    }

    @ResponseBody
    @GetMapping("/api/admin/members")
    public List<AdminAccountResponse> getMembers() {
        return List.of();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @DeleteMapping("/api/admin/members/{userId}")
    public void delete(@PathVariable String userId) {
    }
}
