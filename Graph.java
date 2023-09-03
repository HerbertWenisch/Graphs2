/**
 * @author (Herbert Wenisch)
 * @version (1.c Aufgabe)
 */

import java.util.Arrays;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

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
      if(v >= V ||  w >= V) return;
      if(v < 0 ||  w < 0 ) return;
      adj[v][w] = weight;
    }
    
    public void addEdge(String idv, String idw, int weight){
      addEdge(indexOf(idv), indexOf(idw), weight);
    }
    
    // Gibt zur id den zughörigen Index zurück:
    // Buch KnotenNummerGeben(...)
    private int indexOf(String id){
        for(int v = 0; v < V; v++)
           if(id.equals(ids[v])) return v;
        return -1; // nicht gefunden: Fehler!
    }
    
    // Zeichnet den Graph:
    public void display(){
        graphStream = new GraphStream();
    }
    
    
    // ---------------------------------------------------------------------
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
    
    
    //-------------------------------------------------------------------------------------------
    // Visualisierung des Graphen:
    
    private GraphStream graphStream;
    
    private class GraphStream {
        private final org.graphstream.graph.Graph graph_ = new SingleGraph("showGraph");
        
        GraphStream(){
          setCSS_();  
          addNodes_();
          addEdges_();
          graph_.display();
        }
      
        private void addNodes_(){
          org.graphstream.graph.Node node_;
          for(String id: getIds()){
             node_ = graph_.addNode(id);
             node_.setAttribute("ui.label", id);
           }
       }
       
       // Creates a id for a edge v --> w;  format: idV-idW
       private String getEdgeId_(int v, int w){
           return ids[v] + "-" + ids[w];
        }
        
       private void addEdges_(){
       for(int v = 0; v < V; v++)
          for(int w = 0; w < V; w++){
              if (adj[v][w] > 0){
                  String idE = getEdgeId_(v,w);  // EdgeId
                  org.graphstream.graph.Edge edge_ = graph_.getEdge(idE);
                  if(edge_ == null){
                      edge_ = graph_.addEdge(idE, ids[v], ids[w], true);
                      edge_.setAttribute("ui.label", adj[v][w] + "");
                  }
              }
          }
       }
       
       private void setCSS_(){
        graph_.addAttribute("ui.antialias");
        graph_.addAttribute("ui.quality");
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        String styleSheet =  "node{" +
            "   size: 30px, 30px;" +
            "   text-size: 30;" +
            "   fill-color: #eddeab;" +
            "}" +
            "edge{"+
            " text-size: 25; }";
        graph_.addAttribute("ui.stylesheet", styleSheet);
      }
    }
}


