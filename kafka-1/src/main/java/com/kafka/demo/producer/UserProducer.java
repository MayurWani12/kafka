package com.kafka.demo.producer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.demo.modal.UserEvent;

@Service
public class UserProducer {

    private static final String TOPIC = "my_topic";

    @Autowired
    private KafkaTemplate<String, UserEvent> kafkaTemplate;

    public void sendUserEvent(UserEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
