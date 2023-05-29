package test;


import main.DifferentSizeException;
import main.HammingDist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestHammingDist extends TestMetric<String>{
    @Test
    void testHammingDist() {
        try {
            HammingDist metric = new HammingDist();
            assertEquals(0, metric.dist("", ""));
            assertEquals(0, metric.dist("cat", "cat"));
            assertEquals(1, metric.dist("cat", "bat"));
            assertEquals(1, metric.dist("cat", "car"));
            assertEquals(3, metric.dist("Ai45110", "aI45119"));

            checkPosDef(metric,"Ai45110", "aI45119");
            checkSymmetric(metric,"Ai45110", "aI45119");
            checkTriangIneq(metric,"Ai45110", "aI45119","aI45110");
            checkTriangIneq(metric,"Ai45110", "aI45119","0000000");
        } catch (DifferentSizeException e) {
            fail("Caught DifferentSizeException when no exception expected");
        }
    }

    @Test
    void testDifferentSizeException() {
        try {
            HammingDist metric = new HammingDist();
            int result1 = metric.dist("","a");
            int result2 = metric.dist("a","");
            int result3 = metric.dist("aaaaaaaa","aaaaa");
            fail("DifferentSizeException was not thrown");
        } catch (DifferentSizeException e) {
            // expected
        }
    }
}
