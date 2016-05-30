/**
 * Created by amitdash on 5/30/16.
 * A geometric square shape
 */
public class Square
{
    private double side;

    public Square(double side) {
        if(side < 0)
        {
            throw new RuntimeException("Side cannot be less than zero!");
        }

        this.side = side;
    }

    public double getArea()
    {
        return Math.pow(side, 2);
    }
}

