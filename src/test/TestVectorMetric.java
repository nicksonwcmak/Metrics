package test;

import main.DifferentSizeException;
import main.VectorMetric;

import static org.junit.jupiter.api.Assertions.*;

// class for storing general tests for metrics of vectors
public class TestVectorMetric extends TestMetric<double[]>{
    double d = 0.001; // delta because float/double arithmetic is not exact

    // single-value versions of checkPosDef, checkSymmetric, checkTriangIneq
    void checkPosDef(VectorMetric m, double t1, double t2) {
        assertTrue((m.dist(t1,t2)) >= 0);
        assertEquals(0,m.dist(t1,t1));
        assertEquals(0,m.dist(t2,t2));
    }
    void checkSymmetric(VectorMetric m, double t1, double t2) {
        assertEquals(m.dist(t1,t2),m.dist(t2,t1));
    }

    void checkTriangIneq(VectorMetric m, double t1, double t2, double t3) {
        assertTrue(m.dist(t1,t1) <= m.dist(t1,t2) + m.dist(t2,t1));
        assertTrue(m.dist(t1,t2) <= m.dist(t1,t3) + m.dist(t3,t2));
    }

    // multi-value version of checkPosDef to accommodate double arithmetic
    void checkPosDef(VectorMetric m, double[] t1, double[] t2) {
        assertTrue((m.dist(t1,t2)) >= 0);
        assertEquals(0.0,m.dist(t1,t1),d);
        assertEquals(0.0,m.dist(t2,t2),d);
    }

    // generic test for single number
    void testSingleNumber(VectorMetric metric) {
        assertEquals(0,metric.dist(0,0));
        assertEquals(1,metric.dist(0,1));
        assertEquals(1,metric.dist(0,-1));
        assertEquals(6.7,metric.dist(-9.28,-15.98),d);

        checkPosDef(metric,0.2, -100);
        checkSymmetric(metric,0.2,-100);
        checkTriangIneq(metric, 0.2,-100,1);
    }
    //generic test for different size
    void testDiffSize(VectorMetric metric) {
        try {
            double[] num1 = {1,2};
            double[] num2 = {1};
            Number diff = metric.dist(num1,num2);
            fail("DifferentSizeException was not thrown.");
        } catch (DifferentSizeException e) {
            // expected
        }
    }
}
