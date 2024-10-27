package com.kafka.demo.controller;



import com.kafka.demo.modal.User;
import com.kafka.demo.modal.UserEvent;
import com.kafka.demo.producer.UserProducer;
import com.kafka.demo.modal.UserEventType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserProducer userProducer;

    @PostMapping
    public String createUser(@RequestBody User user) {
        UserEvent event = new UserEvent(UserEventType.CREATE, user);
        userProducer.sendUserEvent(event);
        return "User creation event sent";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User  user) {
        user.setId(id);
        UserEvent event = new UserEvent(UserEventType.UPDATE, user);
        userProducer.sendUserEvent(event);
        return "User update event sent";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        User user = new User(id, null, null);
        UserEvent event = new UserEvent(UserEventType.DELETE, user);
        userProducer.sendUserEvent(event);
        return "User delete event sent";
    }
}
