package com.dytian.where;

import org.nutz.json.Json;

import java.util.ArrayList;
import java.util.List;

public class Condition {

    public static Condition NEW(){
        return new Condition();
    }

    public List<Criterion> wheres = new ArrayList<>();

    public List<Criterion> getWheres() {
        return wheres;
    }

    public Condition eq(String fieldName, Object value){
        wheres.add(new SimpleExpression(fieldName,"=",value));
        return this;
    }


    public Condition gt(String fieldName,Object value){
        wheres.add(new SimpleExpression(fieldName,">",value));
        return this;
    }


    public Condition lt(String fieldName,Object value){
        wheres.add(new SimpleExpression(fieldName,"<",value));
        return this;
    }

    public Condition orderByDesc(String fieldName){
        wheres.add(new OrderBy(fieldName).desc());
        return this;
    }

    public Condition orderByAsc(String fieldName){
        wheres.add(new OrderBy(fieldName).asc());
        return this;
    }


    public static void main(String[] args) {

        Condition where = Condition.NEW();
        where.eq("user_id",99).eq("phone","18363861928");

        List<Criterion> wheres = where.getWheres();
        System.out.println(Json.toJson(wheres));


    }





}
