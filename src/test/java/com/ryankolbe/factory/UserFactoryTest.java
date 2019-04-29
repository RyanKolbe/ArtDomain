package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void createUser() {
        Login login = LoginFactory.createLogin("Ryan", "Fabian");
        Role role = RoleFactory.createRole("Administrator", "User administers system");
        Permission permission = PermissionFactory.createPermission("Administrator",
                "Administrator", "System Administrator",
                "Full System Access");
        Name name = NameFactory.createName("Ryan", "Fabian", "Kolbe");
        Contact contact = ContactFactory.createContact("02195970000", "Landline",
                "ryank@gmail.com");
        User user = UserFactory.createUser(login, role, permission, name, contact);

        Assert.assertEquals("Ryan",user.getLogin().getLoginName());
        Assert.assertEquals("Administrator",user.getRole().getRoleTitle());
        Assert.assertEquals("System Administrator",permission.getPermissionModule());
        Assert.assertEquals("Kolbe",user.getName().getLastName());
        Assert.assertEquals("Landline",user.getContact().getContactNumberType());
    }
}