package test;

import main.AbsValMetric;
import main.DifferentSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAbsValMetric extends TestMetric<double[]>{
    AbsValMetric metric = new AbsValMetric();
    double d = 0.001; // delta because float/double arithmetic is imprecise

    @Test
    void testSingleNumber() {
        assertEquals(0,metric.dist(0,0));
        assertEquals(1,metric.dist(0,1));
        assertEquals(1,metric.dist(0,-1));
        assertEquals(6.7,metric.dist(-9.28,-15.98),d);

        assertTrue(metric.dist(0.2, -100) >= 0);
        assertEquals(0,metric.dist(0.2,0.2));
        assertEquals(0,metric.dist(-100,-100));

        assertEquals(metric.dist(0.2,-100),metric.dist(0.2,-100));

        assertTrue(metric.dist(0.2,0.2)<= metric.dist(0.2,-100) + metric.dist(-100,0.2));
        assertTrue(metric.dist(0.2,-100) <= metric.dist(0.2,1) + metric.dist(1, -100));
    }

    @Test
    void testDiffSize() {
        try {
            double[] num1 = {1,2};
            double[] num2 = {1};
            Number diff = metric.dist(num1,num2);
            fail("DifferentSizeException was not thrown.");
        } catch (DifferentSizeException e) {
            // expected
        }
    }

    @Test
    void testAbsValException() {
        try {
            double[] num1 = {-1};
            double[] num2 = {0};
            assertEquals(1.0,metric.dist(num1,num2));

            double[] num3 = {1,1};
            double[] num4 = {0,0};
            assertEquals(Math.sqrt(2),metric.dist(num3,num4));

            double[] num5 = {1.2,-2.8,0};
            double[] num6 = {0.6,-2,3};
            assertEquals(Math.sqrt(10),metric.dist(num5,num6));

            assertTrue((metric.dist(num5,num6)) >= 0);
            assertEquals(0.0,metric.dist(num5,num5), d);
            assertEquals(0.0,metric.dist(num6,num6), d);

            assertEquals(metric.dist(num5,num6),metric.dist(num6,num5));

            double[] num7 = {0,-3.14,10};
            assertTrue(metric.dist(num5,num5) <= metric.dist(num5, num6) + metric.dist(num6, num5));
            assertTrue(metric.dist(num5, num6) <= metric.dist(num5, num7) + metric.dist(num7, num5));
        } catch (DifferentSizeException e) {
            fail("Caught DifferentSizeException when no exception expected.");
        }
    }
}
