package com.sparta.springusersetting.domain.user.controller;

import com.sparta.springusersetting.config.ApiResponse;
import com.sparta.springusersetting.domain.common.dto.AuthUser;
import com.sparta.springusersetting.domain.user.dto.request.UserChangePasswordRequest;
import com.sparta.springusersetting.domain.user.dto.response.UserResponse;
import com.sparta.springusersetting.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    // 유저 조회 ( id )
    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> getUser(@PathVariable long userId) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUser(userId)));
    }

    // 유저 비밀번호 변경
    @PutMapping("/users")
    public ResponseEntity<ApiResponse<String>> changePassword(@AuthenticationPrincipal AuthUser authUser, @RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        long userId = Long.parseLong(authUser.getUserId());
        return ResponseEntity.ok(ApiResponse.success(userService.changePassword(userId, userChangePasswordRequest)));
    }
}
