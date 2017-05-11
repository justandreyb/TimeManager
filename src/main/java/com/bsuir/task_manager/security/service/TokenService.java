package com.bsuir.task_manager.security.service;

import com.bsuir.task_manager.security.service.exception.AuthenticationException;

public interface TokenService {
    String getToken(String email, String password) throws AuthenticationException;
}
