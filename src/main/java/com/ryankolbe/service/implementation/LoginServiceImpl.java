package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Login;
import com.ryankolbe.repository.LoginRepository;
import com.ryankolbe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login create(Login login) {
        return this.loginRepository.save(login);
    }

    @Override
    public Login read(String loginId) {
        Optional<Login> byId = this.loginRepository.findById(loginId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Login update(Login login) {
        return this.loginRepository.save(login);
    }

    @Override
    public void delete(String loginId) {
        this.loginRepository.deleteById(loginId);
    }

    @Override
    public List<Login> getAll() {
        return this.loginRepository.findAll();
    }
}