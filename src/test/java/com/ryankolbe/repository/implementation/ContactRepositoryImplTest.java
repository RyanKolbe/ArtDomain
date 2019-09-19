/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.factory.ContactFactory;
import com.ryankolbe.repository.ContactRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImplTest {
    private static ContactRepository contactRepository = ContactRepositoryImpl.getContactRepository();
    private static Contact contact;
    private static Set<Contact> contacts = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        contact = ContactFactory.createContact("0001", "0001.email.com", "0820821000",
                "0211001000");
        contacts.add(contactRepository.create(contact));
    }

    @Test
    public void getContactRepository() {
        Assert.assertNotNull(contactRepository);
    }

    @Test
    public void create() {
        Contact createContact = ContactFactory.createContact("0002", "0002.email.com",
                "0720721000", "0119998888");
        contacts.add(contactRepository.create(createContact));
        Assert.assertEquals(createContact, contactRepository.read(createContact.getContactId()));
    }

    @Test
    public void read() {
        Contact readContact = contactRepository.read(contact.getContactId());
        Assert.assertEquals(readContact, contactRepository.read(readContact.getContactId()));
    }

    @Test
    public void update() {
        String newContactEmail = "0003.email.com";
        Contact updateContact = new Contact.Builder().copy(contact).contactEmail(newContactEmail).build();
        contacts.add(contactRepository.update(updateContact));
        Assert.assertEquals(updateContact, contactRepository.read(updateContact.getContactId()));
    }

    @Test
    public void delete() {
        Contact deleteContact = ContactFactory.createContact("0123", "0123.email.com",
                "0823459876", "0312428500");
        contacts.add(contactRepository.create(deleteContact));
        contacts.remove(deleteContact);
        contactRepository.delete(deleteContact.getContactId());
        Assert.assertEquals(contacts.size(), contactRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Contact> contactSet = contactRepository.getAll();
        Assert.assertEquals(contactSet, contactRepository.getAll());
    }
}*/
