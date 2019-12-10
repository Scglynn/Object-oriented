import java.util.*;

public class AdjacencyMatrix<T> {
    //Generics: enables programmers to specify, with a single method declaration
    List<T> nodes = new ArrayList<>();
    int dist[][];

    //The Constructor of taking in the given nodes from the Sample file
    public AdjacencyMatrix(T nodes[]) {
        this.nodes = Arrays.asList(nodes);
        dist = new int[nodes.length][nodes.length];
    }

    //This helps set the distance from A --> B and reversely reversely saying that B --> A is the same distance
    void setDistance(T a, T b, int d) {
        int x = nodes.indexOf(a);
        int y = nodes.indexOf(b);

        if (x < 0 || y < 0) {
            throw new UnsupportedOperationException("item not found");
        }
        dist[x][y] = d;
        dist[y][x] = d; 
    }

    //Gets the distance between two nodes A --> B
     int getDistance(T a, T b) {
        int x = nodes.indexOf(a);
        int y = nodes.indexOf(b);

        if (x == y) {
            return 0;
        }
        if (dist[x][y] == 0) {
            return -1;
        }

        try {
            return dist[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnsupportedOperationException("item not found");
        }
    }

    //get the i-th node
     T getNode(int i) {
        return nodes.get(i);
    }

    //Gets the number of nodes
     int getSize() {
        return nodes.size();
    }

    // This helps set up the table and the format that it needs to be set as
     String getTable(int colWidth) {
        //%10.10s the string format for column width
        String ret = String.format("%" + colWidth + "." + colWidth + "s", " ");

        for (T node : nodes) {
            ret += String.format(" %" + colWidth + "." + colWidth+ "s", node);
        }
        ret += "\n";

        for (int i = 0; i < nodes.size(); i++) {
            ret += String.format("%" + colWidth + "." + colWidth + "s", nodes.get(i));

            for (int j = 0; j < nodes.size(); j++) {
                if (i ==j && dist[i][j] == 0)
                    ret += String.format(" %" + colWidth + "." + colWidth + "s", " ");
                else if (dist[i][j] <= 0)
                    ret += String.format(" %" + colWidth + "." + colWidth + "s", "-");
                else
                    ret += String.format(" %" + colWidth + "." + colWidth + "s", dist[i][j]);
            }
            ret += "\n";
        }
        return ret;
    }

}