package com.dytian.where;

public class OrderBy implements Criterion {

    String fieldName ;

    String orderBy;

    public OrderBy(String fieldName) {
        this.fieldName = fieldName;
    }

    public OrderBy desc(){
        this.orderBy = "desc";
        return this;
    }

    public OrderBy asc(){
        this.orderBy = "asc";
        return this;
    }


}
