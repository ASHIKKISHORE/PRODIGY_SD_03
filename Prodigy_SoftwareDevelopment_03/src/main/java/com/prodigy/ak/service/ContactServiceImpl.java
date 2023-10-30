package com.prodigy.ak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodigy.ak.entity.Contact;
import com.prodigy.ak.repository.ContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	private ContactRepository contactRepository;

	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public List<Contact> getAllContacts() {

		return contactRepository.findAll();
	}

	@Override
	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void deleteStudent(int id) {
		contactRepository.deleteById(id);
	}

	@Override
	public Contact getContactById(int id) {
		return contactRepository.getReferenceById(id);
	}

	@Override
	public Contact updateStudent(Contact contact) {
		return contactRepository.save(contact);
	}

}
