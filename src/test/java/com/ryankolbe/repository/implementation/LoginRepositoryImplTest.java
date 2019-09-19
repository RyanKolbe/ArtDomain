/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Login;
import com.ryankolbe.factory.LoginFactory;
import com.ryankolbe.repository.LoginRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginRepositoryImplTest {
    private static LoginRepository loginRepository = LoginRepositoryImpl.getLoginRepository();
    private static Login login;
    private static Set<Login> logins = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        login = LoginFactory.createLogin("0001", "Deidre", "Pass.123");
        logins.add(loginRepository.create(login));
    }

    @Test
    public void getLoginRepository() {
        Assert.assertNotNull(loginRepository);
    }

    @Test
    public void create() {
        Login createLogin = LoginFactory.createLogin("0002", "Cassidy", "Pass.234");
        logins.add(loginRepository.create(createLogin));
        Assert.assertEquals(createLogin, loginRepository.read(createLogin.getLoginId()));
    }

    @Test
    public void read() {
        Login readLogin = loginRepository.read(login.getLoginId());
        Assert.assertEquals(readLogin, loginRepository.read(readLogin.getLoginId()));
    }

    @Test
    public void update() {
        String newLoginName = "Rhea";
        Login updateLogin = new Login.Builder().copy(login).loginName(newLoginName).build();
        logins.add(loginRepository.update(updateLogin));
        Assert.assertEquals(updateLogin, loginRepository.read(updateLogin.getLoginId()));
    }

    @Test
    public void delete() {
        Login deleteLogin = LoginFactory.createLogin("0467", "Ryan", "OhMyWord");
        logins.add(loginRepository.create(deleteLogin));
        logins.remove(deleteLogin);
        loginRepository.delete(deleteLogin.getLoginId());
        Assert.assertEquals(logins.size(), loginRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Login> loginSet = loginRepository.getAll();
        Assert.assertEquals(loginSet, loginRepository.getAll());
    }
}*/
