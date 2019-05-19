package com.ryankolbe.factory;

import com.ryankolbe.domain.Admin;

public class AdminFactory {

    public static Admin createAdmin(String adminId, String adminLogin,
                                    String adminPassword) {
        return new Admin.Builder()
                .adminId(adminId)
                .adminLogin(adminLogin)
                .adminPassword(adminPassword)
                .build();
    }
}