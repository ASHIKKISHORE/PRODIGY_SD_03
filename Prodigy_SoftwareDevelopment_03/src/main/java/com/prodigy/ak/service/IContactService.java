package com.prodigy.ak.service;

import java.util.List;

import com.prodigy.ak.entity.Contact;

public interface IContactService {

	List<Contact> getAllContacts();
	
	Contact addContact(Contact contact);
	
	void deleteStudent(int id);
	
	public Contact getContactById(int id);
	
	Contact updateStudent(Contact contact);

}
