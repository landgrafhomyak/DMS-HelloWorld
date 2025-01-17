package com.github.Diosa34.DMS_HelloWorld;

/**
 * Entity coordinate class
 */
public class Coordinates {
    private final Float x; //Поле не может быть null
    private final Integer y; //Поле не может быть null

    public Coordinates(Float x, Integer y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return this.x + ", " + this.y;
    }

    public Float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}