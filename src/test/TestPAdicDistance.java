package test;

import main.PAdicDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPAdicDistance extends TestMetric<Integer> {
    PAdicDistance metric;
    static double d = 0.001; //delta because double arithmetic is imprecise

    @BeforeEach
    void setup() {
        metric = new PAdicDistance(2); //using the smallest prime for simplicity
    }

    @Test
    void testPAdicAbsVal() {
        assertEquals(0.0,metric.PAdicAbsVal(0),d);
        assertEquals(1.0,metric.PAdicAbsVal(1),d);
        assertEquals(1.0,metric.PAdicAbsVal(-1),d);
        assertEquals(0.5,metric.PAdicAbsVal(6),d); //looping?
        assertEquals(0.125,metric.PAdicAbsVal(-8),d);
    }

    @Test
    void testPAdicDistance() {
        //stub
    }
}
