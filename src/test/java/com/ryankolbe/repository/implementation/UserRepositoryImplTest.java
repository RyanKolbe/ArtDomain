package com.ryankolbe.repository.implementation;

import com.ryankolbe.factory.*;
import com.ryankolbe.model.User;
import com.ryankolbe.repository.UserRepository;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryImplTest {

    private static UserRepository userRepository = UserRepositoryImpl.getUserRepository();
    private static User user;
    private static Set<User> users = new HashSet<>();

    @BeforeClass
    public static void setUp() {

        user = UserFactory.createUser(LoginFactory.createLogin("Ryan", "Pass.123"),
                RoleFactory.createRole("Admin", "Administers Server"),
                PermissionFactory.createPermission("Admin", "Administrator",
                        "System Administrators", "Managers server"),
                NameFactory.createName("Ryan", "Fabian", "Kolbe"),
                ContactFactory.createContact("0219597000", "Landline",
                        "ryank@gmail.com"));

        users.add(userRepository.create(user));
    }

    @Test
    public void create() {
        user = UserFactory.createUser(LoginFactory.createLogin("Deidre", "Ans.123"),
                RoleFactory.createRole("User", "End User"),
                PermissionFactory.createPermission("User", "System User",
                        "System User", "End User"),
                NameFactory.createName("Deidre", "Rochelle", "Van Vuuren"),
                ContactFactory.createContact("0219597000", "Landline",
                        "deidrev@gmail.com"));

        Assert.assertEquals(users.size(), userRepository.getAll().size());
    }

    @Test
    public void read() {
        String userId = userRepository.getAll().stream().findFirst().get().getUserId();
        String userIdCheck = userRepository.read(userId).getUserId();
        Assert.assertEquals(userId, userIdCheck);
    }

    @Test
    public void update() {
        String newUserId = Misc.generateId();
        User newUser = new User.Builder().copy(user).userId(newUserId).build();
        Assert.assertEquals(newUserId, newUser.getUserId());
    }

    @Test
    public void delete() {
        userRepository.delete(user.getUserId());
        Assert.assertEquals(1, userRepository.getAll().size());
    }
}