package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.factory.ContactFactory;
import com.ryankolbe.service.ContactService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceImplTest {
    @Autowired
    @Qualifier("ContactServiceImpl")
    private ContactService contactService;
    private Contact contact;
    private Set<Contact> contacts = new HashSet<>();

    @Before
    public void setUp() {
        contact = contactService.create(ContactFactory.createContact("0001", "0001.email.com",
                "0762628979", "0214507555"));
        contacts.add(contact);
    }

    @Test
    public void create() {
        Contact createContact = contactService.create(ContactFactory.createContact("0658",
                "0658.email.com", "0856495987", "0226589651"));
        contacts.add(createContact);
        Assert.assertEquals(createContact, contactService.read(createContact.getContactId()));
    }

    @Test
    public void read() {
        Contact readContact = contactService.read(contact.getContactId());
        Assert.assertEquals(readContact, contactService.read(readContact.getContactId()));
    }

    @Test
    public void update() {
        String newContactEmail = "0214.email.com";
        Contact updateContact = contactService.update(new Contact.Builder().copy(contact)
                .contactEmail(newContactEmail).build());
        contacts.add(updateContact);
        Assert.assertEquals(updateContact, contactService.read(updateContact.getContactId()));
    }

    @Test
    public void delete() {
        contacts.addAll(contactService.getAll());
        Contact deleteContact = contactService.create(ContactFactory.createContact("0002",
                "0002.email.com","0675986546","0315459898"));
        contacts.add(deleteContact);
        contacts.remove(deleteContact);
        contactService.delete(deleteContact.getContactId());
        Assert.assertEquals(contacts.size(), contactService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Contact> contactSet = contactService.getAll();
        Assert.assertEquals(contactSet.size(), contactService.getAll().size());
    }
}