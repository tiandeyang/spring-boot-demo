package com.dytian.com.dytian.applicationeventlistener.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;


public class OrderPaidEvent extends ApplicationEvent {

    private String order_no;
    private BigDecimal amount;


    public OrderPaidEvent(Object source ) {
        super(source);
    }

    public OrderPaidEvent(Object source, String order_no, BigDecimal amount) {
        super(source);
        this.order_no = order_no;
        this.amount = amount;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
