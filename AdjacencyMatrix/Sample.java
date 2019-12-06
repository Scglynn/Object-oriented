class Node {
    public char name;
    public int value;
    public Node(char n,int v) { name=n; value=v; }
    public String toString() { return String.format("%c(%d)",name,value);}
}

class Point {
    public int x,y;
    public Point(int x,int y) { this.x=x; this.y=y; }
    public String toString() { return String.format("(%d,%d)",x,y); }
}

public class Sample {
    public static void main(String [] args) {
        String cities[] = {"Abilene","Nashville","New York"};
        AdjacencyMatrix<String> x = new AdjacencyMatrix<>(cities);
        x.setDistance("Abilene","Nashville",400);
        x.setDistance("New York","Nashville",200);
        assert x.getDistance("Nashville","New York") == 200;
        assert x.getNode(0).equals("Abilene");//access methods
        assert x.getSize() == 3; //retrieve the information that the matrix has
        System.out.println(x.getTable(10));

        Node a = new Node('A',3);
        Node b = new Node('B',4);
        Node c = new Node('C',7);
        Node d = new Node('D',11);
        AdjacencyMatrix<Node> y = new AdjacencyMatrix<>(new Node[] {a,b,c,d}); //building an array with these values
        y.setDistance(a,b,4); //passsing in nodes
        y.setDistance(b,c,3);
        y.setDistance(c,a,8);
        y.setDistance(d,a,1);
        System.out.println(y.getTable(5));

        Point p = new Point(10,30);
        Point q = new Point(20,10);
        Point r = new Point(30,40);
        Point s = new Point(20,50);
        Point t = new Point(20,25);
        AdjacencyMatrix<Point> z = new AdjacencyMatrix<>(new Point[] {p,q,r,s,t});
        for (int i=0; i<z.getSize(); i++) {
            for (int j=0; j<i; j++) {                  //Nested for loop
                Point u = z.getNode(i);
                Point v = z.getNode(j);
                z.setDistance(u,v,(int)Math.sqrt((u.x-v.x)*(u.x-v.x)+(u.y-v.y)*(u.y-v.y)));
            }
        }
        System.out.println(z.getTable(7));

        // should generate an exception
        System.out.println("dist to Memphis = "+x.getDistance("Nashville","Memphis")); //UnsupportedOperationException
    }
}
