package com.fastcampus.boardadminproject.controller;

import com.fastcampus.boardadminproject.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("컨트롤러 - 어드민 유저 관리")
@Import(SecurityConfig.class)
@WebMvcTest(AdminAccountManagementController.class)
class AdminAccountManagementControllerTest {

    private final MockMvc mvc;

    AdminAccountManagementControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 어드민 유저 관리 페이지 - 정상 호출")
    @Test
    void givenNothing_whenRequestingAdminUserAccountManagementView_thenReturnsAdminUserAccountManagementView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/admin/members"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("admin/members"));
    }
}
