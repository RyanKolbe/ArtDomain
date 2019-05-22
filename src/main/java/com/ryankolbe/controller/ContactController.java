package com.ryankolbe.controller;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.service.ContactService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(@Qualifier("ContactServiceImpl") ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Contact create(Contact contact) {
        return contactService.create(contact);
    }

    @PostMapping("/update")
    @ResponseBody
    public Contact update(Contact contact) {
        return contactService.update(contact);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Contact read(@PathVariable String id) {
        return contactService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        contactService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Contact> getAll() {
        return contactService.getAll();
    }
}