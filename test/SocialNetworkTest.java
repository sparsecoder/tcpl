import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SocialNetworkTest {
    @Test
    public void testAddConnection() {
        SocialNetwork network = new SocialNetwork();

        Connection connection = mock(Connection.class);
        when(connection.getFrom()).thenReturn("Kernighan");
        when(connection.getTo()).thenReturn("Ritchie");

        network.add(connection);

        fail("finish me");
    }
}
