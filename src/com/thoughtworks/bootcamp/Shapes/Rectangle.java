package com.thoughtworks.bootcamp.Shapes;

/**
 * Created by amitdash on 5/30/16.
 */
public class Rectangle {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth)
    {
        if(length < 0 || breadth < 0)
        {
            throw new RuntimeException("Length or breadth of a rectangle cannot be less than zero!");
        }

        this.length = length;
        this.breadth = breadth;
    }

    public double getArea()
    {
        return this.length * this.breadth;
    }
}
