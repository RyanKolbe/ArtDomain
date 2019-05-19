package com.ryankolbe.repository;

import com.ryankolbe.domain.Contact;

import java.util.Set;

public interface ContactRepository extends IRepository<Contact, String> {
    Set<Contact> getAll();
}
