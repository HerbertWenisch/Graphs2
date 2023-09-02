
/**
 * @author (Herbert Wenisch)
 * @version (08-18-23)
 */

// unser Beispielgraf:

public class ZeitTauschen {
    private Graph graph;
    
    public ZeitTauschen(){
        graph = new Graph(9); 
        fillUpNodes();
        fillUpEdges();
    }
    
    public Graph getGraph(){
        return graph;
    }
    
    private void fillUpNodes(){
        graph.addNode("Roy");
        graph.addNode("Mass"); 
        graph.addNode("Jen"); 
        graph.addNode("Delina"); 
        graph.addNode("Terry"); 
    }
    
    private void fillUpEdges(){
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 2, 4);
        graph.addEdge(0, 4, 13);
        graph.addEdge(1, 3, 9);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 0, 12);
        graph.addEdge(3, 4, 5);
        graph.addEdge(4, 2, 9);
    }
}
