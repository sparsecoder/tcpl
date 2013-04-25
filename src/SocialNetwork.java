import java.util.Set;
import java.util.HashSet;

public class SocialNetwork {
    private Set<Connection> connections;

    public SocialNetwork() {
        connections = new HashSet<Connection>();
    }

    public void add(Connection connection) {
        connections.add(connection);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Connection connection : connections) {
            sb.append(connection).append('\n');
        }
        return sb.toString();
    }
}
