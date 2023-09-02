/**
 * @author (Herbert Wenisch)
 * @version (1.b Aufgabe)
 */

import java.util.Arrays;

public class Graph{
    private final int V_MAX;
    private int V = 0;  // augenblickliche Knotenanzahl
    private String[] ids;  // BezeichnerFeld für die Knoten 
    private int[][] adj; // Adjazenzmatrix;  Buch: matrix
    
    // erzeugt einen leeren Graf:
    public Graph(int V_MAX){
        this.V_MAX = V_MAX;
        ids = new String[V_MAX];
        adj = new int[V_MAX][V_MAX];
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
     
    // Fügt eine Kante  v ---> w vom Gewicht weight ein
    // Buch: KanteEinfügen(...)
    public void addEdge(int v, int w, int weight){
      // Dein Code! (3 Zeilen)
    }
    
    // -------------------------------------------------------------
    // für den Schüler nicht von Bedeutung:
    
    // Returns a String of given length len, but only the first n charactes 
    // of id, the rest is filled with withespace (len <= 10).
    // Usefull, when drawing the matrix
    private String shortId(String id, int n, int len){
        String whiteSpace10 = "          "; 
        String idPlus = id + whiteSpace10;
        return (idPlus.substring(0,n) + whiteSpace10).substring(0,len);
    }
    
    // gibt die Matrix aus:
    @Override
    public String toString(){ 
       String whiteSpace6 = "      ";  // Länge: 6
       StringBuilder out = new StringBuilder(whiteSpace6);
       // Spaltenbezeichner:
       for(String id: getIds())
          out.append(shortId(id,3,6));
       // Zeilen:   
       for(int v = 0; v < V; v++){
           out.append("\n" + shortId(ids[v],3,6)); // Zeilenbezeichner
           for(int w = 0; w < V; w++) 
              out.append( (adj[v][w] == 0)? whiteSpace6 : (adj[v][w] + whiteSpace6).substring(0,6));
       }      
       return out.toString();
    }
}
