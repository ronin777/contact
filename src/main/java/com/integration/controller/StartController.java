package com.integration.controller;

import javax.validation.Valid;
import com.integration.model.Contact;
import com.integration.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author frvazquez
 * @creacion 13/nov/2018
 *
 */
@RestController
public class StartController {

	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/contacts")
	public Flux<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@PostMapping("/contact")
	public Mono<Contact> createContact(@Valid @RequestBody Contact contact) {
		return contactRepository.save(contact);
	}

	@GetMapping("/contact/{id}")
	public Mono<ResponseEntity<Contact>> getContactById(@PathVariable(value = "id") String id) {
		return contactRepository.findById(id).map(savedContact -> ResponseEntity.ok(savedContact))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/contactdel/{id}")
	public Mono<ResponseEntity<Void>> deleteContact(@PathVariable(value = "id") String id) {
		return contactRepository.findById(id).flatMap(existingContact -> contactRepository.delete(existingContact))
				.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
