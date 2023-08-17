package com.blogproject.springbootblogrestapi.service;

import com.blogproject.springbootblogrestapi.payload.LoginDto;
import com.blogproject.springbootblogrestapi.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
