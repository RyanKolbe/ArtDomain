package com.ryankolbe.repository;

import com.ryankolbe.model.Contact;

import java.util.Set;

public interface ContactRepository extends IRepository<Contact, String> {
    Set<Contact> getAll();
}
