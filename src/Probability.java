/**
 * Created by amitdash on 5/30/16.
 */
public class Probability {

    public double getProbabilityVal() {
        return probabilityVal;
    }

    double probabilityVal;

    public Probability(double value)
    {
        if(value > 1 || value < 0)
        {
            throw new RuntimeException("Invalid probability");
        }
        this.probabilityVal = value;
    }

    public Probability negate() {
        return new Probability(1D - probabilityVal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        return Double.compare(that.probabilityVal, probabilityVal) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(probabilityVal);
        return (int) (temp ^ (temp >>> 32));
    }
    //    public Probability or(Probability p1, Probability p2) {
//        return 0;
//    }
}
