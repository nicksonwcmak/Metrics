package test;

import main.DifferentSizeException;
import main.TaxicabMetric;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestTaxicabMetric extends TestVectorMetric{
    TaxicabMetric metric = new TaxicabMetric();

    @Test
    void testSingleNumber() {
        super.testSingleNumber(metric);
    }

    @Test
    void testDiffSize() {
        super.testDiffSize(metric);
    }

    @Test
    void testAbsValException() {
        try {
            double[] num1 = {-1};
            double[] num2 = {0};
            assertEquals(1.0,metric.dist(num1,num2));

            double[] num3 = {1,1};
            double[] num4 = {0,0};
            assertEquals(2,metric.dist(num3,num4));

            double[] num5 = {1.2,-2.8,0};
            double[] num6 = {0.6,-2,3};
            assertEquals(4.4,metric.dist(num5,num6),d);

            checkPosDef(metric,num5,num6);
            checkSymmetric(metric,num5,num6);
            double[] num7 = {0,-3.14,10};
            checkTriangIneq(metric,num5,num6,num7);
        } catch (DifferentSizeException e) {
            fail("Caught DifferentSizeException when no exception expected.");
        }
    }
}
