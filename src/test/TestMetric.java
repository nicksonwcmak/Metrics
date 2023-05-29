package test;

import main.Metric;

import static org.junit.jupiter.api.Assertions.*;

public abstract class TestMetric<T> {
    void checkPosDef(Metric<T> m, T t1, T t2) {
        assertTrue((m.dist(t1,t2)).doubleValue() >= 0);
        assertEquals(0,m.dist(t1,t1));
        assertEquals(0,m.dist(t2,t2));
    }

    void checkSymmetric(Metric<T> m, T t1, T t2) {
        assertEquals(m.dist(t1,t2),m.dist(t2,t1));
    }

    void checkTriangIneq(Metric<T> m, T t1, T t2, T t3) {
        assertTrue(m.dist(t1,t1).doubleValue() <= m.dist(t1,t2).doubleValue() + m.dist(t2,t1).doubleValue());
        assertTrue(m.dist(t1,t2).doubleValue() <= m.dist(t1,t3).doubleValue() + m.dist(t3,t1).doubleValue());
    }
}
