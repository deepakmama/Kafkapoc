package com.deepak.kafka.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deepak.kafka.spring.boot.dto.Employee;
import com.google.gson.Gson;

@Service
public class KafkaSenderService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private Gson gson;

	String kafkaTopic = "deepak_topic_one";
	String kafkaTopic1 = "deepak_topic_two";

	public void send(String message) {
		kafkaTemplate.send(kafkaTopic, message);
	}

	public void send(Employee employee) {
		kafkaTemplate.send(kafkaTopic1, gson.toJson(employee));
	}
}
