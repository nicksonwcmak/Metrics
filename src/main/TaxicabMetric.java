package main;

// a class representing the taxicab metric/Manhattan distance.
public class TaxicabMetric extends VectorMetric{
    // returns the taxicab/Manhattan distance between vectors represented by t1 and t2
    @Override
    public Double dist(double[] t1, double[] t2) {
        super.checkSameLength(t1,t2);
        double sum = 0;
        for (int i=0; i < t1.length; i++) {
            sum += Math.abs(t1[i] - t2[i]);
        }
        return sum;
    }
}
