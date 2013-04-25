import java.awt.Dimension;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

public class SocialNetwork {
    private Set<Connection> connections;
    private Set<String> nodes;

    public static void main(String[] args) throws IOException {
        SocialNetwork network = new SocialNetwork();

        Scanner scanner = new Scanner(new File(args[0]));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            String from = lineScanner.next();
            String to = lineScanner.next();
            network.add(new Connection(from, to));
        }

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

        JFrame frame = new JFrame("Simple Graph View");
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
