import java.awt.Dimension;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class SocialNetwork {
    private Set<Connection> connections;
    private Set<String> nodes;

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        throw new UnsupportedOperationException("Finish me!");

        network.visualize();
    }

    public SocialNetwork() {
        connections = new HashSet<Connection>();
        nodes = new HashSet<String>();
    }

    public void add(Connection connection) {
        connections.add(connection);
        nodes.add(connection.getFrom());
        nodes.add(connection.getTo());
    }

    public void visualize() {
        DirectedGraph<String, Connection> graph = makeGraph();

        Layout<String, Connection> layout =
            new CircleLayout<String, Connection>(graph);
        layout.setSize(new Dimension(300,300));

        BasicVisualizationServer<String, Connection> server =
            new BasicVisualizationServer<String, Connection>(layout);
        server.setPreferredSize(new Dimension(350,350));
        server.getRenderContext().setVertexLabelTransformer(
            new ToStringLabeller<String>());
        server.getRenderer().getVertexLabelRenderer().setPosition(
            Position.CNTR);

        JFrame frame = new JFrame("Social Network");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(server);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public String toString() {
        return makeGraph().toString();
    }

    private DirectedGraph<String, Connection> makeGraph() {
        DirectedGraph<String, Connection> graph = 
            new DirectedSparseGraph<String, Connection>();
        for (String node : nodes) {
            graph.addVertex(node);
        }
        for (Connection connection : connections) {
            graph.addEdge(connection, connection.getFrom(), connection.getTo());
        }
        return graph;
    }
}
