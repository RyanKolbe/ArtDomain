package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.repository.ContactRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ContactRepository")
public class ContactRepositoryImpl implements ContactRepository {
    private static ContactRepositoryImpl contactRepository = null;
    private Set<Contact> contacts;


    private ContactRepositoryImpl() {
        this.contacts = new HashSet<>();
    }

    public static ContactRepositoryImpl getContactRepository() {
        if (contactRepository == null) contactRepository = new ContactRepositoryImpl();
        return contactRepository;
    }

    @Override
    public Contact create(Contact contact) {
        this.contacts.add(contact);
        return contact;
    }

    @Override
    public Contact read(String contactId) {
        return search(contactId);
    }

    @Override
    public Contact update(Contact contact) {
        Contact contactTemp = search(contact.getContactId());
        if (contactTemp != null) {
            contacts.remove(contactTemp);
            return create(contact);
        }
        return null;
    }

    @Override
    public void delete(String contactId) {
        Contact contactDelete = search(contactId);
        if (contactDelete != null) this.contacts.remove(contactDelete);
    }

    private Contact search(final String contactId) {
        for (Contact contactSearch : this.contacts) {
            if (contactSearch.getContactId().equals(contactId))
                return contactSearch;
        }
        return null;
    }

    @Override
    public Set<Contact> getAll() {
        return this.contacts;
    }
}