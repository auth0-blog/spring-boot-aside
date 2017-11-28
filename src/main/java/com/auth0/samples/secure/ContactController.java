package com.auth0.samples.secure;

import com.google.common.collect.Lists;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts/")
public class ContactController {
    private static final List<Contact> contacts = Lists.newArrayList(
            Contact.builder().name("Bruno Krebs").phone("+5551987654321").build(),
            Contact.builder().name("John Doe").phone("+5551888884444").build()
    );

    @GetMapping
    @PreAuthorize("hasAuthority('read:contacts')")
    public List<Contact> getContacts() {
        return contacts;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('add:contacts')")
    public void addContact(@RequestBody Contact contact) {
        contacts.add(contact);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('delete:contacts')")
    public void clearContacts() {
        contacts.clear();
    }
}
