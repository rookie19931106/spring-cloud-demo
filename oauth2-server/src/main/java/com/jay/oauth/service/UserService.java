package com.jay.oauth.service;

import com.jay.oauth.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 加载用户信息类
 */
@Service
public class UserService implements UserDetailsService {

    private List<User> users;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initData(){
        String password = passwordEncoder.encode("123456");
        users = new ArrayList<>();
        users.add(new User("jay",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        users.add(new User("andy",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        users.add(new User("mike",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> findUserList = users.stream().filter(user -> user.getUsername().equals(s)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)){
            return findUserList.get(0);
        }else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }
}
