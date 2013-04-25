import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

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
        layout.setSize(new Dimension(700,525));

        BasicVisualizationServer<String, Connection> server =
            new BasicVisualizationServer<String, Connection>(layout);
        server.setPreferredSize(new Dimension(800,600));
        server.getRenderContext().setVertexLabelTransformer(
            new ToStringLabeller<String>());
        server.getRenderer().getVertexLabelRenderer().setPosition(
            Position.CNTR);
        server.getRenderContext().setVertexShapeTransformer(
            new Transformer<String,Shape>() {
                public Shape transform(String s){
                    return new Ellipse2D.Double(-50, -15, 100, 30);
                }
            });
        server.getRenderContext().setVertexFillPaintTransformer(
            new Transformer<String,Paint>() {
                public Paint transform(String s) {
                    return Color.GREEN;
                }
            });

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
