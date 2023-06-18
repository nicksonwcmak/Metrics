package test;

import main.PAdicDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPAdicDistance extends TestMetric<Integer> {
    PAdicDistance metric;
    static double d = 0.001; //delta because double arithmetic is imprecise
    int prime = 2;

    @BeforeEach
    void setup() {
        metric = new PAdicDistance(prime); //using the smallest prime for simplicity
    }

    @Test
    void testGetPrime() {
        assertEquals(prime,metric.getPrime());
    }

    @Test
    void testPAdicAbsVal() {
        assertEquals(0.0,metric.PAdicAbsVal(0),d);
        assertEquals(1.0,metric.PAdicAbsVal(1),d);
        assertEquals(1.0,metric.PAdicAbsVal(-1),d);
        assertEquals(0.5,metric.PAdicAbsVal(6),d);
        assertEquals(0.125,metric.PAdicAbsVal(-8),d);
    }

    @Test
    void testPAdicDistance() {
        assertEquals(0.0,metric.dist(0,0),d); //distance 0
        assertEquals(1.0,metric.dist(1,-10),d); // 11 apart, no factor of 2
        assertEquals(0.5,metric.dist(0,-10),d); // 10 apart, one factor of 2
        assertEquals(0.25,metric.dist(-6,-10),d); // 4 apart, two factors of 2
        assertEquals(0.0625,metric.dist(6,-10),d); // 16 apart, four factors of 2

        checkPosDef(metric,6,-10);
        checkSymmetric(metric,-10,6);
        checkTriangIneq(metric,6,-10,0);
    }
}
