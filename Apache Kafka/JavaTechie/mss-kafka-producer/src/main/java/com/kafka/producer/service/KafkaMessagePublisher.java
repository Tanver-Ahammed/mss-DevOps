package com.kafka.producer.service;

import com.kafka.producer.config.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = this.template.send(AppConstants.TOPIC_NAME, message);
//        try {
//            Thread.sleep(4 * 5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        future.whenComplete((result, ex) -> {
            if (ex == null)
                System.err.println("Sent message=[" + message + "] with offset [" + result.getRecordMetadata().offset() + "]");
            else
                System.err.println("Unable to Sent message=[" + message + "] due to [" + result.getRecordMetadata().offset() + "]");
        });
    }


}
