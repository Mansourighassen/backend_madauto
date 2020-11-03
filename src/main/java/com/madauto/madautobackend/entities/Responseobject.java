package com.madauto.madautobackend.entities;

public class Responseobject {
    String body;
    String type;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Responseobject(String body, String type) {
        this.body = body;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
