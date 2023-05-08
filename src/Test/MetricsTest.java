package Test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// method tests for the Metrics
public class MetricsTest {
    @Test
    void testDiscreteMetric() {
        Metric<Number> metric = new DiscreteMetric();
        assertEquals(1, metric.dist(1, 3));
        assertEquals(1,metric.dist(-0.1,0));
        assertEquals(0,metric.dist(1,1));
    }
    void checkPosDef() {} //stub
    void checkSymmetric() {} // stub
    void checkTriangIneq() {} //stub
}
