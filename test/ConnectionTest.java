import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectionTest {
    @Test
    public void testNodeGetters() {
        String kernighan = "Kernighan";
        String ritchie = "Ritchie";

        Connection connection = new Connection(kernighan, ritchie);
        assertEquals(kernighan, connection.getFrom());
        assertEquals(ritchie, connection.getTo());
    }
}
