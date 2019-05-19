package com.ryankolbe.factory;

import com.ryankolbe.domain.Login;
import com.ryankolbe.util.Misc;

public class LoginFactory {

    public static Login createLogin(String loginName, String password) {
        return new Login.Builder()
                .loginId(Misc.generateId())
                .loginName(loginName)
                .password(password)
                .build();
    }
}