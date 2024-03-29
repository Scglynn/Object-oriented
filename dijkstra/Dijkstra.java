class DijkstrasAlgorithm { 
  
    private static final int NO_PARENT = -1; 
    private static void dijkstra(int[][] adjacencyMatrix, int startVertex) { 
        int nVertices = adjacencyMatrix[0].length; 
        int[] shortestDistances = new int[nVertices]; 

        boolean[] added = new boolean[nVertices]; 

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
        { 
            shortestDistances[vertexIndex] = Integer.MAX_VALUE; 
            added[vertexIndex] = false; 
        } 
          
        // Distance of source vertex is always starting at 0 or A!
        shortestDistances[startVertex] = 0; 

  
        // Parent array stores the shortest path
        int[] parents = new int[nVertices]; 

        parents[startVertex] = NO_PARENT; 
        // Find shortest path for all vertices
        for (int i = 1; i < nVertices; i++) { 
            int nearestVertex = -1; 
            int shortestDistance = Integer.MAX_VALUE; 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex; 
                    shortestDistance = shortestDistances[vertexIndex]; 
                } 
            } 
            added[nearestVertex] = true; 

            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex]; 
                  
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) { 
                    parents[vertexIndex] = nearestVertex; 
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance; 
                } 
            } 
        } 
  
        printSolution(startVertex, shortestDistances, parents); 
    } 

    private static void printSolution(int startVertex, int[] distances, int[] parents) 
    { 
        int nVertices = distances.length; 
        System.out.printf("\tTable A\n");
        System.out.print("Vertex:\t    Distance:\t       Path:"); 
          
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)  
        { 
            if (vertexIndex != startVertex)  
            { 
                System.out.print("\n" + startVertex + " -> "); 
                System.out.print(vertexIndex + " \t\t "); 
                System.out.print(distances[vertexIndex] + "\t\t"); 
                printPath(vertexIndex, parents); 
            } 
        } 
    }

    private static void printPath(int currentVertex, int[] parents) 
    {
        if (currentVertex == NO_PARENT) 
        { 
            return; 
        } 
        printPath(parents[currentVertex], parents); 
        System.out.print(currentVertex + " "); 
    } 
  

    public static void main(String[] args) 
    { 
        int[][] adjacencyMatrix =  {{0,3,2,0,0,0,0,0,0},
                                    {3,0,7,0,0,4,0,0,0},
                                    {2,7,0,3,3,0,0,0,6},
                                    {0,0,3,0,0,1,2,0,0},
                                    {0,0,3,0,0,3,0,3,2},
                                    {0,4,0,1,3,0,4,3,0},
                                    {0,0,0,2,0,4,0,0,0},
                                    {0,0,0,0,3,3,0,0,1},
                                    {0,0,6,0,2,0,0,1,0}};
        dijkstra(adjacencyMatrix, 0); 
    } 
}

