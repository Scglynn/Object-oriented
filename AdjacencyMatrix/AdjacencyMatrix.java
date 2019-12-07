import java.util.*;

public class AdjacencyMatrix<T> {
    List<T> nodes = new ArrayList<>();
    int dist1[][];

    public AdjacencyMatrix(T nodes[]) {
        this.nodes = Arrays.asList(nodes);
        dist1 = new int[nodes.length][nodes.length];
    }
    public void setDistance(T a, T b, int d) {
        int x = nodes.indexOf(a);
        int y = nodes.indexOf(b);

        if (x < 0 || y < 0) {
            throw new UnsupportedOperationException("item not found");
        }
        dist1[x][y] = d;
        dist1[y][x] = d; 
    }

    public int getDistance(T a, T b) {
        int x = nodes.indexOf(a);
        int y = nodes.indexOf(b);

        if (x ==y)
            return 0;
        if (dist1[x][y] == 0)
            return -1;

        try {
            return dist1[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnsupportedOperationException("item not found");
        }
    }

    public T getNode(int i) {
        return nodes.get(i);
    }

    public int getSize() {
        return nodes.size();
    }

    public String getTable(int colWidth) {
        String ret = String.format("%" + colWidth + "." + colWidth + "s", " ");

        for (T node : nodes) {
            ret += String.format("%" + colWidth + "." + colWidth+ "s", node);
        }
        ret += "\n";

        for (int i = 0; i < nodes.size(); i++) {
            ret += String.format("%" + colWidth + "." + colWidth + "s", nodes.get(i));

            for (int j = 0; j < nodes.size(); j++) {
                if (i ==j && dist1[i][j] == 0)
                    ret += String.format("%" + colWidth + "." + colWidth + "s", " ");
                else if (dist1[i][j] < 0)
                    ret += String.format("%" + colWidth + "." + colWidth + "s", "-");
                else
                    ret += String.format("%" + colWidth + "." + colWidth + "s", dist1[i][j]);
            }
            ret += "\n";
        }
        return ret;
    }

}