package Test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// method tests for the Metrics
public class TestDiscreteMetric extends TestMetric<Number>{
    @Test
    void testDiscreteMetric() {
        DiscreteMetric metric = new DiscreteMetric();
        assertEquals(1, metric.dist(1, 3));
        assertEquals(1,metric.dist(-0.0001,0));
        assertEquals(0,metric.dist(1,1));
        checkPosDef(metric,-1.001, 3.14);
        checkSymmetric(metric,-1.001,3.14);
        checkTriangIneq(metric,-1.001,3.14,0); // distances are equal
        checkTriangIneq(metric,1,2,0); //distances are inequal
    }

}
