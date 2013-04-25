import org.junit.Test;
import static org.junit.Assert.*;

public class EdgeTest {
    @Test
    public void testNodeGetters() {
        Edge edge = new Edge("apple", "pear");
        assertEquals("apple", edge.getFromNode());
        assertEquals("pear", edge.getToNode());
    }
}
