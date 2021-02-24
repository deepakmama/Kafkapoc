package com.deepak.kafka.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.deepak.kafka.spring.boot.dto.Employee;
import com.google.gson.Gson;

@Service
public class KafkaListenerService {

	@Autowired
	private Gson gson;

	@KafkaListener(topics = { "deepak_topic_two" })
	public void getTopics(@RequestBody String emp) {
		System.out.println("Kafka event consumed is: " + emp);
		Employee model = gson.fromJson(emp, Employee.class);
		System.out.println("Model converted value: " + model.toString());
	}
}
