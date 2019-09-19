package com.ryankolbe.service;

import com.ryankolbe.domain.Contact;

import java.util.List;

public interface ContactService extends IService<Contact, String> {
    List<Contact> getAll();
}