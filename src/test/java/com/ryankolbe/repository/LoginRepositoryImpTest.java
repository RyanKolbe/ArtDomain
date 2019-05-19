package com.ryankolbe.repository;

import com.ryankolbe.factory.LoginFactory;
import com.ryankolbe.domain.Login;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginRepositoryImpTest {
    private static LoginRepository loginRepository = LoginRepositoryImp.getLoginRepository();
    private static Login login;
    private static Set<Login> logins = new HashSet<>();


    @BeforeClass
    public static void setUp() {
        login = LoginFactory.createLogin("Ryan", "Pass.123");
        logins.add(loginRepository.create(login));
    }

    @Test
    public void getLoginRepository() {
        Assert.assertNotNull(loginRepository);
    }

    @Test
    public void create() {
        Login createLogin = LoginFactory.createLogin("Deidre", "Rochelle.123");
        logins.add(loginRepository.create(createLogin));
        Assert.assertEquals(createLogin, loginRepository.read(createLogin.getLoginId()));
    }

    @Test
    public void read() {
        Login readLogin = loginRepository.read(loginRepository.getAll().iterator().next().getLoginId());
        Login loginIdCheck = loginRepository.read(readLogin.getLoginId());
        Assert.assertEquals(readLogin, loginIdCheck);
    }

    @Test
    public void update() {
        String loginId = Misc.generateId();
        Login newLogin = new Login.Builder()
                .copy(login)
                .loginId(loginId)
                .build();
        logins.add(newLogin);
        Assert.assertEquals(loginId, newLogin.getLoginId());
    }

    @Test
    public void delete() {
        loginRepository.delete(login.getLoginId());
        logins.remove(login);
        Assert.assertEquals(logins.size(),loginRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Login> logins = loginRepository.getAll();
        Assert.assertEquals(logins, loginRepository.getAll());
    }
}