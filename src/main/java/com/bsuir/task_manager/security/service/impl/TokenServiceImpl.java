package com.bsuir.task_manager.security.service.impl;

import com.bsuir.task_manager.security.service.TokenService;
import com.bsuir.task_manager.security.service.exception.AuthenticationException;
import com.bsuir.task_manager.security.service.exception.PasswordDoesntMatchSecurityException;
import com.bsuir.task_manager.security.service.exception.UserNotFoundSecurityException;
import com.bsuir.task_manager.security.util.SecurityUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    private final static String TOKEN_KEY = "task_manager";
    private final static String EMAIL = "EMAIL";
    private final static String USER_ID = "USER_ID";
    private final static String EXPIRATION_DATE = "TOKEN_EXPIRATION_DATE";
    private static final String NICKNAME = "NICKNAME";
    private static final String IS_ADMIN = "IS_ADMIN";

    private UserDetailsService userDetailsService;

    @Autowired
    public TokenServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String getToken(String email, String password) throws AuthenticationException {

        if (email == null || password == null) {
            throw new UserNotFoundSecurityException("Email or password are empty");
        }

        SecurityUser user;
        try {
            user = (SecurityUser) userDetailsService.loadUserByUsername(email);
        } catch (UsernameNotFoundException exception) {
            throw new UserNotFoundSecurityException("User with this email not found. ", exception);
        }

        Map<String, Object> tokenData = new HashMap<String, Object>();

        if (password.equals(user.getPassword())) {
            tokenData.put(USER_ID, user.getId());
            tokenData.put(EMAIL, user.getUsername());
            tokenData.put(NICKNAME, user.getNickname());

            boolean admin = user.getAuthorities().contains(new SimpleGrantedAuthority("admin"));

            tokenData.put(IS_ADMIN, admin);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);
            tokenData.put(EXPIRATION_DATE, calendar.getTime());

            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);

            return jwtBuilder.signWith(SignatureAlgorithm.HS512, TOKEN_KEY).compact();
        } else {
            throw new PasswordDoesntMatchSecurityException("Wrong password!");
        }
    }
}
