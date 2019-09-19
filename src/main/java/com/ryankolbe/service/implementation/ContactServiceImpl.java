package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.repository.ContactRepository;
import com.ryankolbe.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ContactServiceImpl")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAll() {
        return this.contactRepository.findAll();
    }

    @Override
    public Contact create(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact read(String contactId) {
        Optional<Contact> byId = this.contactRepository.findById(contactId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Contact update(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public void delete(String contactId) {
        this.contactRepository.deleteById(contactId);
    }
}