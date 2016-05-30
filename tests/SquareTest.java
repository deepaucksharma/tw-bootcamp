import org.junit.Assert;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by amitdash on 5/30/16.
 */
public class SquareTest {
    @org.junit.Test
    public void getArea() throws Exception {
        Square sq = new Square(10);
        Assert.assertThat(sq.getArea(), is(100));
    }

}