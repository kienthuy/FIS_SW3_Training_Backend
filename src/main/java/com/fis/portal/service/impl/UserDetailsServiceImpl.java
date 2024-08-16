package com.fis.portal.service.impl;

import com.fis.portal.mapper.UserMapper;
import com.fis.portal.model.User;
import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userMapper.findByCode(username);
    if (Objects.isNull(user)) {
      throw new UsernameNotFoundException("Người dùng không tồn tại");
    }

    return new org.springframework.security.core.userdetails.User(
            user.getCode(), user.getPassword(), new ArrayList<>());
  }
}

