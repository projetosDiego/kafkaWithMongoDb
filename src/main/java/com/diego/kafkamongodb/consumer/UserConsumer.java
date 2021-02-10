package com.diego.kafkamongodb.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.diego.kafkamongodb.domain.User;
import com.diego.kafkamongodb.repository.UserRepository;
import com.diego.kafkamongodb.util.JsonMapper;

@Service
public class UserConsumer {
	
	@Autowired
	private UserRepository userRepository;
	
	@KafkaListener(topics="topic", groupId="id")
	public void getMessage(String userDto) {
		User user = JsonMapper.jsonToObject(userDto);
		userRepository.save(user);
	}

}
