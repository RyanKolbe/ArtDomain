package com.ryankolbe.controller;

import com.ryankolbe.domain.Contact;
import com.ryankolbe.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/create")
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/update")
    @ResponseBody
    public Contact update(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Contact read(@PathVariable String id) {
        return contactService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        contactService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Contact> getAll() {
        return contactService.getAll();
    }
}