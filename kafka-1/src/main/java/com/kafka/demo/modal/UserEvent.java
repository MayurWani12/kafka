package com.kafka.demo.modal;


public class UserEvent {
    private UserEventType type;
    private User user;

    public UserEvent() {}

    public UserEvent(UserEventType type, User user) {
        this.type = type;
        this.user = user;
    }

	public UserEventType getType() {
		return type;
	}

	public void setType(UserEventType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

  
}
