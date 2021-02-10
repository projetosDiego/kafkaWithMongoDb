package com.diego.kafkamongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diego.kafkamongodb.domain.dto.UserDTO;
import com.diego.kafkamongodb.producer.UserProducer;

@RestController
public class UserController {
	
	@Autowired
	private UserProducer producer;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
		producer.writeMessage(userDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
