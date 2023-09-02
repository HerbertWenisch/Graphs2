/**
 * @author (Herbert Wenisch)
 * @version (1.a Lösung)
 */

import java.util.Arrays;

public class Graph{
    private final int V_MAX;
    private int V = 0;  // augenblickliche Knotenanzahl
    private String[] ids;  // BezeichnerFeld für die Knoten 
    
    // erzeugt einen leeren Graf:
    public Graph(int V_MAX){
        this.V_MAX = V_MAX;
        ids = new String[V_MAX];
    }
    
    // Buch: KnotenEinfügen(...)
    public void addNode(String id){
        if(V == V_MAX) return;
        ids[V] = id;
        V++;
    }

    // Gibt einen vollen Array ohne Freiplätze zurück.
    // Vorteil: for-each-Schleife anwendbar
    public String[] getIds(){
        return Arrays.copyOf(ids, V);
    }
    
}
