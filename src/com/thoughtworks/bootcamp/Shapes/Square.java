package com.thoughtworks.bootcamp.Shapes;

/**
 * Created by amitdash on 5/30/16.
 * A geometric square shape
 */
public class Square
{
    private Rectangle squaredRectangle;

    public Square(double side) {
        if(side < 0)
        {
            throw new RuntimeException("Side of a square cannot be less than zero!");
        }

        this.squaredRectangle = new Rectangle(side, side);
    }

    public double getArea()
    {
        return this.squaredRectangle.getArea();
    }
}

