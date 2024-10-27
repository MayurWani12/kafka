package com.kafka.demo.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics = "my_topic", groupId = "my-group")
    public void consumeUserEvent(com.kafka.demo.modal.UserEvent event) {
        switch (event.getType()) {
            case CREATE:
                System.out.println("Create user: " + event.getUser());
                break;
            case UPDATE:
                System.out.println("Update user: " + event.getUser());
                break;
            case DELETE:
                System.out.println("Delete user: " + event.getUser().getId());
                break;
            default:
                break;
        }
    }
}
