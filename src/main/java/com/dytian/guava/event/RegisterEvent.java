package com.dytian.guava.event;

public class RegisterEvent implements Event {

    String phone;

    public RegisterEvent(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
