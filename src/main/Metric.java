package main;

// class representing a metric space
// T is a template type representing the thing we are measuring
public interface Metric<T> {
    /* returns distance between t1 and t2
    For all t1, t2, dist(t1,t2) has the following properties:
    1) dist(t1,t2) >= 0
    2) iff t1 == t2, then dist(t1,t2) == 0
    3) dist(t1,t2) == dist (t2, t1)
    4) for any T t3, we have dist(t1,t2) <= dist(t1,t3) + dist(t3,t2)
     */
    Number dist(T t1, T t2);
}
