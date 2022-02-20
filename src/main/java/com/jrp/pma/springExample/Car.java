package com.jrp.pma.springExample;

public class Car {

    Engine engine;
    Doors doors;
    Tires tires;

    public Car(Engine engine, Doors doors, Tires tires) {
        this.engine = engine;
        this.doors = doors;
        this.tires = tires;
    }

    public void printCarDetails() {
        System.out.println(this.engine + " " + this.doors);
    }
}
