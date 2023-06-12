package main;

// class that acts as an abstraction for metrics over tuples of
public abstract class VectorMetric implements Metric<double[]> {
    // checks if t1 and t2 have the same length
    // throws DifferentSizeException if not
    public void checkSameLength(double[] t1, double[] t2) {
        if (t1.length != t2.length) {
            throw new DifferentSizeException();
        }
    }

    // declares that dist will return a Double - to make tests easier
    @Override
    public abstract Double dist(double[] t1, double[] t2);

    // returns absolute value distance between t1 and t2
    // which is equal to the taxicab/Manhattan distance between t1 and t2
    // used for the case of t1 and t2 being single numbers
    public double dist(double t1, double t2) {
        return Math.abs(t1 - t2);
    }
}
