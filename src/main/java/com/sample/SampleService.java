package com.sample;

import java.util.logging.Logger;

public class SampleService {

	private static Logger logger = Logger.getLogger(SampleService.class.getName());

	private final MessageRepository messageRepository;

	public SampleService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public String generateMessage() {
		logger.info("generate message");
		return messageRepository.getMessage();
	}
}
