package com.diego.kafkamongodb.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.diego.kafkamongodb.domain.dto.UserDTO;
import com.diego.kafkamongodb.util.JsonMapper;

@Service
public class UserProducer {
	
	private static final String TOPIC = "topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void writeMessage(UserDTO userDto) {
		kafkaTemplate.send(TOPIC, JsonMapper.objectToJson(userDto));
	}

}
