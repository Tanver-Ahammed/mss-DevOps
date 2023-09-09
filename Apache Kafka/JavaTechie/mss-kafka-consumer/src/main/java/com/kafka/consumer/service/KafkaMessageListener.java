package com.kafka.consumer.service;

import com.kafka.consumer.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consumeMessage1(String message) {
        log.info("Consumer1 consume the message: " + message);
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consumeMessage2(String message) {
        log.info("Consumer2 consume the message: " + message);
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consumeMessage3(String message) {
        log.info("Consumer3 consume the message: " + message);
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consumeMessage4(String message) {
        log.info("Consumer4 consume the message: " + message);
    }

}
