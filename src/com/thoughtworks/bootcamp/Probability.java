package com.thoughtworks.bootcamp;

/**
 * Created by amitdash on 5/30/16.
 */
public class Probability {

    public double getOdds() {
        return odds;
    }

    double odds;

    public Probability(double value) {
        if (value > 1 || value < 0) {
            throw new RuntimeException("Invalid probability");
        }

        this.odds = value;
    }

    public Probability negate() {
        return new Probability(1D - odds);
    }

    public Probability and(Probability probability) {
        return new Probability(this.odds * probability.odds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        return Double.compare(that.odds, odds) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(odds);
        return (int) (temp ^ (temp >>> 32));
    }

    //    public Probability or(Probability p1, Probability p2) {
//        return 0;
//    }
}
