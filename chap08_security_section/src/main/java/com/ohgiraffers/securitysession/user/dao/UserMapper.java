package com.ohgiraffers.securitysession.user.dao;

import com.ohgiraffers.securitysession.user.model.dto.LoginUserDTO;
import com.ohgiraffers.securitysession.user.model.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int regist(SignUpDTO signUpDTO);

    LoginUserDTO findByUserName(String username);
}
