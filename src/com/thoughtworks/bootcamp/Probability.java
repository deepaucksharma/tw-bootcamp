package com.thoughtworks.bootcamp;

/**
 * Created by amitdash on 5/30/16.
 * Job: Represents chance of an event, encapsulates the probability operations
 */
public class Probability {
    public static final int MAXIMUM_CHANCE = 1;
    private double chance;

    public Probability(double chance) {
        if (chance > 1 || chance < 0) {
            throw new RuntimeException("Invalid probability");
        }

        this.chance = chance;
    }

    private double round(double chance)
    {
        return Math.round(chance * 10000) / 10000.0;
    }

    public Probability negate() {
        return new Probability(this.round(MAXIMUM_CHANCE - chance));
    }

    public Probability and(Probability that) {
        return new Probability(this.round(this.chance * that.chance));
    }

    public Probability or(Probability that) {
        return new Probability(this.round(this.chance + that.chance));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        return Double.compare(that.chance, chance) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(chance);
        return (int) (temp ^ (temp >>> 32));
    }
}
