package com.prodigy.ak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodigy.ak.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
