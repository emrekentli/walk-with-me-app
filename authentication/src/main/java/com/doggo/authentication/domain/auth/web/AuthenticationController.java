package com.doggo.authentication.domain.auth.web;

import com.doggo.authentication.domain.auth.api.AuthService;
import com.doggo.authentication.domain.auth.api.ForgotPasswordDto;
import com.doggo.authentication.domain.auth.api.SignInDto;
import com.doggo.authentication.domain.auth.api.SignUpDto;
import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.core.rest.BaseController;
import com.doggo.core.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationController extends BaseController {
    private final AuthService service;

    @PostMapping("/signin")
    public Response<AuthResponse> signIn(@RequestBody SignInDto dto) throws Exception {
        UserDto userDto = service.signIn(dto);
        return respond(AuthResponse.fromDto(userDto));
    }

    @PostMapping("/signup")
    public Response<AuthResponse> signUp(@RequestBody SignUpDto dto) {
        return respond(AuthResponse.fromDto(service.signUp(dto)));
    }

    @PostMapping("forgotpsw")
    public Response<AuthResponse> forgotPasword(@RequestBody ForgotPasswordDto dto) {
        return respond(AuthResponse.fromDto(service.forgotPassword(dto)));
    }
}
