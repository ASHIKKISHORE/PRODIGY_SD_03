package com.prodigy.ak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prodigy.ak.entity.Contact;
import com.prodigy.ak.service.IContactService;

@Controller
public class ContactController {

	private IContactService service;

	public ContactController(IContactService service) {
		this.service = service;
	}

	@RequestMapping("/contacts")
	String getAllStudents(Model model) {
		model.addAttribute("contacts", service.getAllContacts());
		return "contacts";
	}

	@RequestMapping("/contacts/add")
	String addContactForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "add_contacts";
	}

	@PostMapping("/insertContact")
	String addContact(@ModelAttribute("contact") Contact contact) {
		service.addContact(contact);
		return "redirect:/contacts";
	}

	@RequestMapping("contacts/delete/{id}")
	String deleteContact(@PathVariable("id") int id, Model model) throws Exception {
		service.deleteStudent(id);
		return "redirect:/contacts";
	}

	@GetMapping("contacts/update/{id}")
	String updateContactForm(@PathVariable("id") int id, Model model) throws Exception {
		Contact contact = new Contact();
		model.addAttribute("contact", service.getContactById(id));
		return "update_contacts";
	}

	@PostMapping("contacts/{id}")
	String editContact(@PathVariable int id, @ModelAttribute("contact") Contact contact) {
		Contact existingContact = service.getContactById(id);

		existingContact.setId(id);
		existingContact.setFirstName(contact.getFirstName());
		existingContact.setLastName(contact.getLastName());
		existingContact.setPhoneNumber(contact.getPhoneNumber());
		existingContact.setEmail(contact.getEmail());

		service.updateStudent(existingContact);
		return "redirect:/contacts";
	}
}
