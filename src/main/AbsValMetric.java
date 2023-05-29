package main;

// represents the "usual" absolute value distance
public class AbsValMetric extends VectorMetric{
    // returns the absolute value distance between vectors represented by t1 and t2
    @Override
    public Double dist(double[] t1, double[] t2) {
        super.checkSameLength(t1,t2);
        double sum = 0;
        for (int i = 0; i < t1.length; i++) {
            sum += ((t1[i] - t2[i]) * (t1[i] - t2[i]));
        }
        return Math.sqrt(sum);
    }
}
