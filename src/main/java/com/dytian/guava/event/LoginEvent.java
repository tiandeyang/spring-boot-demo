package com.dytian.guava.event;

public class LoginEvent implements Event {

    String user_id ;

    public LoginEvent(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
