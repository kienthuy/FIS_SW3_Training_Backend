package com.fis.portal.service.impl;

import com.fis.portal.mapper.UserMapper;
import com.fis.portal.model.BaseResponse;
import com.fis.portal.model.User;
import com.fis.portal.provider.JwtProvider;
import com.fis.portal.service.IAuthService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public BaseResponse authentication(User request) {
    Authentication authed = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getCode(), request.getPassword()));
    UserDetails userDetails = (UserDetails) authed.getPrincipal();
    return new BaseResponse(JwtProvider.generateToken(userDetails.getUsername()));
  }

  @Override
  public BaseResponse register(User user) {
	  try {
		  User userCheck = userMapper.findByCode(user.getCode());
          if (Objects.nonNull(userCheck)) {
            return new BaseResponse("1", "Username đã tồn tại");
          }

          user.setPassword(passwordEncoder.encode(user.getPassword()));
          user.setRoleCode("USER");

          // Thực hiện tạo mới người dùng
          int result = userMapper.register(user);
          if(result > 0) {
              return new BaseResponse("0","Tạo người dùng thành công");
          }else {
              return new BaseResponse("1","Tạo người dùng thất bại");
          }

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
        return new BaseResponse("1","Tạo người dùng thất bại");
	}
    
  }
}
