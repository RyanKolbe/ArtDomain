package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Login;
import com.ryankolbe.repository.LoginRepository;
import com.ryankolbe.repository.implementation.LoginRepositoryImpl;
import com.ryankolbe.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    private LoginServiceImpl() {
        this.loginRepository = LoginRepositoryImpl.getLoginRepository();
    }

    @Override
    public Login create(Login login) {
        return this.loginRepository.create(login);
    }

    @Override
    public Login read(String loginId) {
        return this.loginRepository.read(loginId);
    }

    @Override
    public Login update(Login login) {
        return this.loginRepository.update(login);
    }

    @Override
    public void delete(String loginId) {
        this.loginRepository.delete(loginId);
    }

    @Override
    public Set<Login> getAll() {
        return this.loginRepository.getAll();
    }
}