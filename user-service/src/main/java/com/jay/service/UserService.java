package com.jay.service;

import com.jay.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jay
 * @date 2020/1/11 22:18
 */
public interface UserService {
    void create(User user);
    User getUser(Long id);
    void update(User user);
    void delete(Long id);
    User getByUsername(String username);
    List<User> getUserByIds(List<Long> ids);
}
