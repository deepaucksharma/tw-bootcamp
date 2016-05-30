package com.thoughtworks.bootcamp;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by amitdash on 5/30/16.
 */
public class ProbabilityTest {
    @Test(expected = RuntimeException.class)
    public void invalidProbabilityShouldThrowException()
    {
        Probability p = new Probability(2);
    }

    @Test
    public void testEquality() {
        Probability a = new Probability(.5);
        Probability b = new Probability(.5);
        Probability c = new Probability(.5);


        Assert.assertThat(a, Is.is(a));

        Assert.assertThat(a, Is.is(b));
        Assert.assertThat(b, Is.is(b));

        Assert.assertThat(a, Is.is(b));
        Assert.assertThat(b, Is.is(c));
        Assert.assertThat(a, Is.is(c));

        Assert.assertFalse(a.equals(null));
        Assert.assertFalse(a.equals(new Object()));
        Assert.assertFalse(a.equals(new Probability(0.1)));
    }

    @Test
    public void testNegateOperation() {
        Assert.assertThat(new Probability(0.6).negate(), is(new Probability(0.4)));
    }

    @Test
    public void testAndOperation() {
        Assert.assertThat(new Probability(0.3).and(new Probability(0.3)), is(new Probability(0.09)));
    }

//    @Test
//    public void orTest()
//    {
//        double p1 = 0.6,p2=.1;
//        double expected = p1 + p2;
//        Assert.assertThat(probEng.or(p1, p2), is(expected));
//    }
}
