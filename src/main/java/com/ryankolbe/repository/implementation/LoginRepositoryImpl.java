/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Login;
import com.ryankolbe.repository.LoginRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginRepositoryImpl implements LoginRepository {
    private static LoginRepositoryImpl loginRepository = null;
    private Set<Login> logins;

    private LoginRepositoryImpl() {
        this.logins = new HashSet<>();
    }

    public static LoginRepositoryImpl getLoginRepository() {
        if (loginRepository == null) loginRepository = new LoginRepositoryImpl();
        return loginRepository;
    }

    @Override
    public Login create(Login login) {
        this.logins.add(login);
        return login;
    }

    @Override
    public Login read(String loginId) {
        return search(loginId);
    }

    @Override
    public Login update(Login login) {
        Login loginTemp = search(login.getLoginId());
        if (loginTemp != null) {
            logins.remove(loginTemp);
            return create(login);
        }
        return null;
    }

    @Override
    public void delete(String loginId) {
        Login deleteLogin = search(loginId);
        if (deleteLogin != null) this.logins.remove(deleteLogin);
    }

    @Override
    public Set<Login> getAll() {
        return this.logins;
    }

    private Login search(final String loginId) {
        for (Login loginSearch : this.logins) {
            if (loginSearch.getLoginId().equals(loginId)) return loginSearch;
        }
        return null;
    }
}
*/
