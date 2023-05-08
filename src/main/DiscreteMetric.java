package main;// represents the discrete metric

public class DiscreteMetric implements Metric<Number> {
    // returns the distance between t1 and t2 under the discrete metric
    // if t1 == t2, returns 0; otherwise returns 1
    @Override
    public Number dist(Number t1, Number t2) {
        return t1.equals(t2) ? 0 : 1;
    }
}
