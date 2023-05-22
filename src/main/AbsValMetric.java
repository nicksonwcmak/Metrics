package main;

// represents the "usual" absolute value distance
public class AbsValMetric implements Metric<Double[]>{
    // returns the absolute value distance between t1 and t2
    // interprets t1, t2 as Cartesian coordinates
    // [Number not used due to reliance on arithmetic]
    // throws DifferentSizeException if t1 and t2 don't have the same number of elements
    @Override
    public Double dist(Double[] t1, Double[] t2) {
        if (t1.length != t2.length) {
            throw new DifferentSizeException();
        }
        double sum = 0;
        for (int i = 0; i < t1.length; i++) {
            sum += ((t1[i] - t2[i]) * (t1[i] - t2[i]));
        }
        return Math.sqrt(sum);
    }

    // returns absolute value distance between t1 and t2
    // used for the case of t1 and t2 being single numbers
    public Double dist(Double t1, Double t2) {
        return Math.abs(t1 - t2);
    }
}
