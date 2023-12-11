package com.ohgiraffers.securitysession.user.service;

import com.ohgiraffers.securitysession.user.dao.UserMapper;
import com.ohgiraffers.securitysession.user.model.dto.LoginUserDTO;
import com.ohgiraffers.securitysession.user.model.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public int regist(SignUpDTO signUpDTO){
        signUpDTO.setUserPass(encoder.encode(signUpDTO.getUserPass()));
        int result = userMapper.regist(signUpDTO);

        return result;
    }

    public LoginUserDTO findByUserName(String username) {
        System.out.println(username);
        LoginUserDTO login = userMapper.findByUserName(username);
        System.out.println(login);
        if(!Objects.isNull(login)){
            return login;
        }else{
            return null;
        }
    }
}
