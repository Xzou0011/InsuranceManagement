package com.im.service;

import com.im.model.WebUser;;
import com.im.repository.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserSecurity implements UserDetailsService {

    @Autowired
    private WebUserRepository webUserRepository;

    // only need to override this method because we just want to
    // 1. customise how to retrieve user data from DB
    // 2. customise how to deal with username not exist
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        WebUser user = webUserRepository.login(userName);
//        System.out.println(user);// debug use it
        if (null == user) {
            throw new UsernameNotFoundException("User name not defined");
        }
        org.springframework.security.core.userdetails.User result =
                new org.springframework.security.core.userdetails.User(
                        // using the data from DB to create spring security user
                        // this is the real user which spring security used
                        userName, user.getPwd(), AuthorityUtils.createAuthorityList(user.getRole())
                );
        return result;
    }

}