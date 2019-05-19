package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Login;
import com.ryankolbe.repository.LoginRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginRepositoryImp implements LoginRepository {
    private static LoginRepository loginRepository = null;
    private Set<Login> logins;

    private LoginRepositoryImp() {
        this.logins = new HashSet<>();
    }

    public static LoginRepository getLoginRepository() {
        if (loginRepository == null) loginRepository = new LoginRepositoryImp();
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
            return new Login.Builder()
                    .copy(loginTemp)
                    .build();
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
