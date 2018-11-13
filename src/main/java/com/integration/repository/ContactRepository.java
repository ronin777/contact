package com.integration.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.integration.model.Contact;

/**
 * 
 * @author frvazquez
 * @creacion 13/nov/2018
 *
 */
@Repository
public interface ContactRepository extends ReactiveMongoRepository<Contact, String> {

}
