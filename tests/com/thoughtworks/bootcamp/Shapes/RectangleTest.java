package com.thoughtworks.bootcamp.Shapes;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by amitdash on 5/30/16.
 */
public class RectangleTest {
    @Test(expected = RuntimeException.class)
    public void invalidRectangleShouldThrowException()
    {
        Rectangle invalidRectangle = new Rectangle(-2, 1);
    }

    @Test
    public void testGetArea()
    {
        Rectangle rectangle = new Rectangle(3, 3);
        Assert.assertThat(rectangle.getArea(), is(9D));
    }
}