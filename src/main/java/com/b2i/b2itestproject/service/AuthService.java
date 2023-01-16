package com.b2i.b2itestproject.service;


import com.b2i.b2itestproject.payload.LoginDto;
import com.b2i.b2itestproject.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
