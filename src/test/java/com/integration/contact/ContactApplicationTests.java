package com.integration.contact;

import java.util.HashMap;
import java.util.Map;

import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.integration.model.Contact;
import com.integration.repository.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactApplicationTests {

	String uri = "http://localhost:8090";
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Test
	@Ignore
	public void getContacts() {
		RestTemplate restTemplate = new RestTemplate();
		String resultado = restTemplate.getForObject(uri + "/contacts", String.class);
		System.out.println("\n\nLista de Contactos \n\n" + resultado + "\n");
	}

	@Test
	@Ignore
	public void createContact() {
		Contact contact = new Contact();
        DataFactory df = new DataFactory();
        
		for (int i = 0; i < 100; i++) {
			contact.setNames(df.getName());
			contact.setLastnames(df.getLastName());
			contact.setEmail(df.getEmailAddress());
			contact.setTel(df.getNumberText(10));
		}
		
		RestTemplate restTemplate = new RestTemplate();
		Contact resultadoContacto = restTemplate.postForObject(uri + "/contact", contact, Contact.class);
		
		System.out.println("\n\nNuevo Contacto \n\n" + resultadoContacto.toString() + "\n");
	}
	
	@Test
	@Ignore
	public void getContactId() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "5beb2a24fb6fc06239e30bdb");
		RestTemplate restTemplate = new RestTemplate();
		Contact contacto = restTemplate.getForObject(uri + "/contact/{id}", Contact.class, params);
		System.out.println("\n\nContacto \n" + contacto.toString() +"\n ");
	}
	
	@Test
	@Ignore
	public void deleteContact() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "5beb2a24fb6fc06239e30bdb");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri + "/contactdel/{id}", params);
		System.out.println("\n\nContacto Eliminado\n");
	}
	
}
