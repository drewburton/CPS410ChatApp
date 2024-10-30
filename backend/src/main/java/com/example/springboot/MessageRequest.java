package com.example.springboot;

import java.util.Date;

public class MessageRequest {
    private Long id;

    private String user;

    private String text;

    private Date timestamp;

    public MessageRequest(Long id, String user, String text, Date timestamp) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
