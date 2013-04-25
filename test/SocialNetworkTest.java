import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SocialNetworkTest {
    private final static String PERSON1 = "Kernighan";
    private final static String PERSON2 = "Ritchie";

    @Test
    public void testAddConnection() {
        SocialNetwork network = new SocialNetwork();

        Connection connection = mock(Connection.class);
        when(connection.getFrom()).thenReturn(PERSON1);
        when(connection.getTo()).thenReturn(PERSON2);
        when(connection.toString()).thenReturn(PERSON1 + "->" + PERSON2);

        network.add(connection);

        System.out.println(network);

        fail("finish me");
    }
}
