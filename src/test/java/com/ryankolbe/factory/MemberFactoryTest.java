package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import org.junit.Assert;
import org.junit.Test;

public class MemberFactoryTest {

    @Test
    public void createMember() {
        Login login = LoginFactory.createLogin("Ryan", "Fabian");
        Role role = RoleFactory.createRole("Administrator", "User administers system");
        Permission permission = PermissionFactory.createPermission("Administrator",
                "Administrator", "System Administrator",
                "Full System Access");
        Name name = NameFactory.createName("Ryan", "Fabian", "Kolbe");
        Contact contact = ContactFactory.createContact("0219597000", "Landline",
                "ryank@gmail.com");
        User user = UserFactory.createUser(login, role, permission, name, contact);
        Address address = AddressFactory.createAddress("10", "Trumpet",
                "Street");
        Locality locality = LocalityFactory.createLocality("Steenberg", "Western Cape",
                "South Africa", "7945");
        Member member = MemberFactory.createMember(user, address, locality);

        Assert.assertEquals("Ryan", member.getUser().getLogin().getLoginName());
        Assert.assertEquals("Administrator", member.getUser().getRole().getRoleTitle());
        Assert.assertEquals("Administrator", member.getUser().getPermission().getPermissionRole());
        Assert.assertEquals("Kolbe", member.getUser().getName().getLastName());
        Assert.assertEquals("0219597000", member.getUser().getContact().getContactNumber());
        Assert.assertEquals("Trumpet", member.getAddress().getStreetName());
        Assert.assertEquals("Steenberg", member.getLocality().getRegisteredName());
    }
}