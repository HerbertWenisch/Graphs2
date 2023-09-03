
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
        graph.addEdge("Roy", "Mass", 8);
        graph.addEdge("Roy", "Jen", 4);
        graph.addEdge("Roy", "Terry", 13);
        graph.addEdge("Mass", "Delina", 9);
        graph.addEdge("Jen", "Mass", 2);
        graph.addEdge("Jen", "Delina", 8);
        graph.addEdge("Delina", "Roy", 12);
        graph.addEdge("Delina", "Terry", 5);
        graph.addEdge("Terry", "Jen", 9);
    }
}
