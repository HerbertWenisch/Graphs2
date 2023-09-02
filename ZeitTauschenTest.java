import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ZeitTauschenTest.
 *
 * @author  (Herbert Wenisch)
 * @version (08-20-23)
 */
public class ZeitTauschenTest {
    private ZeitTauschen zeitTauschen;
    private Graph graph;
    
    @BeforeEach
    public void setUp(){
        zeitTauschen = new ZeitTauschen();
        graph = zeitTauschen.getGraph(); 
    }

    
    @Test
    public void test_knotens(){
        System.out.println("- ids der Knoten:");
        for(String id: graph.getIds())
            System.out.print(id + "  ");
        System.out.println();    
    }
    
    @Test
    public void test_addEdge(){
        System.out.println("- Adjazenzmatrix: \n");
        System.out.print(graph);
        System.out.println();    
    }
}


