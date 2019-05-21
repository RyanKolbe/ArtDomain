package com.ryankolbe.service;

import com.ryankolbe.domain.Contact;

import java.util.Set;

public interface ContactService extends IService<Contact, String> {
    Set<Contact> getAll();
}