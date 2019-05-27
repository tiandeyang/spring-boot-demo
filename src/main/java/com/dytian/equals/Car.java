package com.dytian.equals;

import java.util.HashSet;
import java.util.Set;

public class Car {

    /*下面根据“类是否覆盖equals()方法”，将它分为2类。
            (01) 若某个类没有覆盖equals()方法，当它的通过equals()比较两个对象时，实际上是比较两个对象是不是同一个对象。这时，等价于通过“==”去比较这两个对象。
            (02) 我们可以覆盖类的equals()方法，来让equals()通过其它方式比较两个对象是否相等。通常的做法是：若两个对象的内容相等，则equals()方法返回true；否则，返回fasle
    */
    /*1. 对称性：如果x.equals(y)返回是"true"，那么y.equals(x)也应该返回是"true"。
            2. 反射性：x.equals(x)必须返回是"true"。
            3. 类推性：如果x.equals(y)返回是"true"，而且y.equals(z)返回是"true"，那么z.equals(x)也应该返回是"true"。
            4. 一致性：如果x.equals(y)返回是"true"，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是"true"。
            5. 非空性，x.equals(null)，永远返回是"false"；x.equals(和x不同类型的对象)永远返回是"false"。*/

    public Car() {

    }

    public Car(String engine, String model) {
        this.engine = engine;
        this.model = model;
    }

    private String engine;
    private String model;

    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        Car o1 = (Car) o;
        return o1.engine.equals(this.engine) && o1.model.equals(this.model);
    }

    @Override
    public int hashCode() {
        String str = this.engine + this.model;
        return str.hashCode();
    }

    public static void main(String[] args) {

        Car car = new Car("fengtian","89");
        Car car1 = new Car("fengtian","89");

        System.out.println("60========="+car.equals(car1));
        Set<Car> cars = new HashSet<>();
        cars.add(car);
        cars.add(car1);
        System.out.println(cars.size());
        // 如果不重写  hashCode  则 set 长度为 2；重写后  长度为 1
    }

}


