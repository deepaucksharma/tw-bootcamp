package com.thoughtworks.bootcamp;

/**
 * Created by amitdash on 5/30/16.
 * Job: Represents value of an event, encapsulates the probability operations
 */
public class Probability {
    public static final int MAXIMUM_CHANCE = 1;
    private double value;

    public Probability(double value) {
        if (value > 1 || value < 0)
            throw new RuntimeException("Invalid probability");

        this.value = value;
    }

    private double round(double chance) {
        return Math.round(chance * 10000) / 10000.0;
    }

    public Probability negate() {
        return new Probability(this.round(MAXIMUM_CHANCE - value));
    }

    public Probability and(Probability that) {
        return new Probability(this.round(this.value * that.value));
    }

    public Probability or(Probability that) {
        return new Probability(this.round((this.value + that.value) - (this.and(that).value)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }
}
