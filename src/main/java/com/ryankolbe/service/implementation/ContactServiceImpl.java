package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.repository.ContactRepository;
import com.ryankolbe.repository.implementation.ContactRepositoryImpl;
import com.ryankolbe.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ContactServiceImpl")
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    private ContactServiceImpl() {
        this.contactRepository = ContactRepositoryImpl.getContactRepository();
    }

    @Override
    public Set<Contact> getAll() {
        return this.contactRepository.getAll();
    }

    @Override
    public Contact create(Contact contact) {
        return this.contactRepository.create(contact);
    }

    @Override
    public Contact read(String contactId) {
        return this.contactRepository.read(contactId);
    }

    @Override
    public Contact update(Contact contact) {
        return this.contactRepository.update(contact);
    }

    @Override
    public void delete(String contactId) {
        this.contactRepository.delete(contactId);
    }
}