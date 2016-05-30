package com.thoughtworks.bootcamp.Shapes;

import com.thoughtworks.bootcamp.Shapes.Square;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by amitdash on 5/30/16.
 */
public class SquareTest {
    @Test(expected = RuntimeException.class)
    public void invalidSquareShouldThrowException()
    {
        Square invalidSquare = new Square(-2);
    }

    @Test
    public void testGetArea() throws Exception {
        Square sq = new Square(10);
        Assert.assertThat(sq.getArea(), is(100.0));
    }

}