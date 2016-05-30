import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by amitdash on 5/30/16.
 */
public class ProbabilityTest {
    Probability value;
    @Before
    public void setUp() throws Exception {
       value  = new Probability(0.6);
    }

    @Test
    public void testEquality()
    {
        Probability a = new Probability(.5);
        Probability b = new Probability(.5);
        Probability c = new Probability(.5);


        Assert.assertThat(a, is(a));

        Assert.assertThat(a, is(b));
        Assert.assertThat(b, is(b));

        Assert.assertThat(a, is(b));
        Assert.assertThat(b, is(c));
        Assert.assertThat(a, is(c));

        Assert.assertFalse(a.equals(null));
        Assert.assertFalse(a.equals(new Object()));
        Assert.assertFalse(a.equals(new Probability(0.1)));
    }

    @Test
    public void negationTest()
    {
        Assert.assertThat(value.negate().equals(new Probability(0.4)), is(true));
    }

//    @Test
//    public void orTest()
//    {
//        double p1 = 0.6,p2=.1;
//        double expected = p1 + p2;
//        Assert.assertThat(probEng.or(p1, p2), is(expected));
//    }
}
