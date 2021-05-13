package com.rperaza.app.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rperaza.app.model.SocialMedia;
import com.rperaza.app.repository.SocialMediaRepository;

@RestController
@RequestMapping("/api/socialmedia")
public class SocialMediaController {

	@Autowired
	private SocialMediaRepository SocialMediaRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<SocialMedia>> getSocialMedias() {
		return new ResponseEntity<>(SocialMediaRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSocialMedia(@PathVariable long id) {
		Optional<SocialMedia> socialmedia = SocialMediaRepo.findById(id);

		if (!socialmedia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(socialmedia);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addParty(@RequestBody SocialMedia socialmedia) {
		return new ResponseEntity<>(SocialMediaRepo.save(socialmedia), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePartyn(@PathVariable long id) {
		SocialMediaRepo.deleteById(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
