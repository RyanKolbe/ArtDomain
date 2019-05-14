package com.ryankolbe.repository;

import com.ryankolbe.factory.ContactFactory;
import com.ryankolbe.model.Contact;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImpTest {
    private static ContactRepository contactRepository = ContactRepositoryImp.getContactRepository();
    private static Contact contact;
    private static Set<Contact> contacts = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        contact = ContactFactory.createContact("0219597000", "Landline",
                "ryank@gmail.com");
        contacts.add(contactRepository.create(contact));
    }

    @Test
    public void getContactRepository() {
        Assert.assertNotNull(contactRepository);
    }

    @Test
    public void create() {
        contact = ContactFactory.createContact("0820822000", "Cellphone",
                "ryank@gmail.com");
        contacts.add(contactRepository.create(contact));
        Assert.assertEquals(contact, contactRepository.read(contact.getContactId()));
    }

    @Test
    public void read() {
        contact = ContactFactory.createContact("0820822000", "Cellphone",
                "ryank@gmail.com");
        contacts.add(contactRepository.create(contact));
        Contact contactTemp = contactRepository.read(contact.getContactId());
        Assert.assertEquals(contactTemp, contact);
    }

    @Test
    public void update() {
        String contactId = Misc.generateId();
        Contact contactNew = new Contact.Builder().copy(contacts.iterator().next())
                .contactId(contactId)
                .build();
        Assert.assertEquals(contactId, contactNew.getContactId());
    }

    @Test
    public void delete() {

        Contact deleteContact = ContactFactory.createContact("0219597000", "Landline",
                "deidrev@gmail.com");
        contacts.add(contactRepository.create(deleteContact));
        contactRepository.delete(deleteContact.getContactId());
        contacts.remove(deleteContact);
        Assert.assertEquals(contacts.size(), contactRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Contact> contacts = contactRepository.getAll();
        Assert.assertEquals(contacts, contactRepository.getAll());

    }

    @Test
    public void search() {
    }
}