package Test;

import main.Metric;

public abstract class TestMetric<T> {
    void checkPosDef(Metric<T> m, T t1, T t2) {

    }
    void checkSymmetric(Metric<T> m, T t1, T t2) {} // stub
    void checkTriangIneq(Metric<T> m, T t1, T t2) {} //stub
}
