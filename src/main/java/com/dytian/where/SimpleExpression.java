package com.dytian.where;


public class SimpleExpression implements Criterion{
      
    private String fieldName;       //属性名  
    private Object value;           //对应值  
    private String operator;      //计算符
  
    protected SimpleExpression(String fieldName,String operator, Object value) {
        this.fieldName = fieldName;  
        this.value = value;  
        this.operator = operator;  
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}