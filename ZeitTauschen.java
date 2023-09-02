
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
    
}
