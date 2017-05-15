package com.bsuir.task_manager.security.service.impl;

import com.bsuir.task_manager.bean.view.RoleView;
import com.bsuir.task_manager.bean.view.UserView;
import com.bsuir.task_manager.security.util.SecurityUser;
import com.bsuir.task_manager.service.UserService;
import com.bsuir.task_manager.service.exception.NotFoundServiceException;
import com.bsuir.task_manager.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public SecurityUser loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        try {
            userEmail = URLDecoder.decode(userEmail, "UTF-8");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        UserView user = null;

        try {
            user = userService.getUserByEmail(userEmail);

            List<GrantedAuthority> authorities = getUserRoles(user);
            return new SecurityUser(user.getEmail(), user.getPassword(), user.getNickname(), user.getId(),
                    !user.isDeleted(), true, true, true,
                    authorities);
        } catch (NotFoundServiceException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch (ServiceException e) {
            throw new UsernameNotFoundException("Something went wrong.. " + e.getMessage());
        }
    }

    private List<GrantedAuthority> getUserRoles(UserView user) {
        List<GrantedAuthority> result = new ArrayList<>(0);
        RoleView role = user.getRole();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getValue());
        result.add(grantedAuthority);
        return result;
    }
}
