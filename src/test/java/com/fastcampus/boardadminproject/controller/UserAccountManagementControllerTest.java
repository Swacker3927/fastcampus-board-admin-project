package com.fastcampus.boardadminproject.controller;

import com.fastcampus.boardadminproject.config.SecurityConfig;
import com.fastcampus.boardadminproject.dto.UserAccountDto;
import com.fastcampus.boardadminproject.service.UserAccountManagerService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("컨트롤러 - 회원 관리")
@Import(SecurityConfig.class)
@WebMvcTest(UserAccountManagementController.class)
class UserAccountManagementControllerTest {

    private final MockMvc mvc;
    @MockBean private UserAccountManagerService userAccountManagerService;

    UserAccountManagementControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 회원 관리 페이지 - 정상 호출")
    @Test
    void givenNothing_whenRequestingUserAccountManagementView_thenReturnsUserAccountManagementView() throws Exception {
        // Given
        given(userAccountManagerService.getUserAccounts()).willReturn(List.of());

        // When & Then
        mvc.perform(get("/management/user-accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("management/user-accounts"))
                .andExpect(model().attribute("userAccounts", List.of()));
        then(userAccountManagerService).should().getUserAccounts();
    }

    @DisplayName("[data][GET] 회원 1개 - 정상 호출")
    @Test
    void givenUserAccountId_whenRequestingUserAccount_thenReturnsUserAccount() throws Exception {
        // Given
        String userId = "uno";
        UserAccountDto userAccountDto = createUserAccountDto(userId, "Uno");
        given(userAccountManagerService.getUserAccount(userId)).willReturn(userAccountDto);

        // When & Then
        mvc.perform(get("/management/user-accounts/" + userId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(userId))
                .andExpect(jsonPath("$.nickname").value(userAccountDto.nickname()));
        then(userAccountManagerService).should().getUserAccount(userId);
    }

    @DisplayName("[view][POST] 회원 삭제 - 정상 호출")
    @Test
    void givenUserAccountId_whenRequestingDeletion_thenRedirectsToUserAccountManagementView() throws Exception {
        // Given
        String userId = "uno";
        willDoNothing().given(userAccountManagerService).deleteUserAccount(userId);

        // When & Then
        mvc.perform(
                post("/management/user-accounts/" + userId)
                        .with(csrf())
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/management/user-accounts"))
                .andExpect(redirectedUrl("/management/user-accounts"));
        then(userAccountManagerService).should().deleteUserAccount(userId);
    }

    private UserAccountDto createUserAccountDto(String userId, String nickname) {
        return UserAccountDto.of(
                userId,
                "uno-test@email.",
                nickname,
                "test memo"
        );
    }
}
