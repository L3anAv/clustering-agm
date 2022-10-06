package clusteringAGM;

import java.util.LinkedList;

public class Sistema {

	private Grafo grafo;
	private LinkedList<String> listaVertices; /* Una lista SOLO de nombres de vertices 
													agregados al sistema. */
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de Sistema.</u>
	 * 
	 **/
	
	public Sistema(){
		
		grafo = new Grafo();
		listaVertices = new LinkedList<String>();
		
	}

	/**
	 * <b>agregarVertice(): </b></br>
	 * <u>Metodo que inserta un nuevo vertice en el grafo con su posicion correspondiente.</u>
	 * 
	 * @param nombreDelVertice
	 * <i>Nombre del vertice.</i>
	 * @param posicionX
	 * <i>Coordenada del vertice en X.</i>
	 * @param posicionY
	 * <i>Coordenada del vertice en Y.</i>
	 **/
	
	public void agregarVertice(String nombreDelVertice, double posicionX, double posicionY) {
		
		listaVertices.add(nombreDelVertice);
		grafo.insertarVertice(nombreDelVertice, posicionX, posicionY);
		
	}
	
	// Crear artistas del grafo, unir el grafo
	
//	public void crearGrafo() {
//		for (int i = 0; i < listaVertices.size(); ++i) { // O(n**3)
//			for (String vertice1 : listaVertices.keySet()) {
//				for (String vertice2 : listaVertices.keySet()) {
//					if (listaVertices.get(vertice1) != listaVertices.get(vertice2)) {   //vertice1 != vertice2
//						grafo.agregarArista(listaVertices.get(vertice1), listaVertices.get(vertice2));
//						
//					}
//
//				}
//			}
//		}
//			
//		//grafo.arbolGeneradorMinimo(); // Una vez que tengo el grafo completo, recorto para generar un arbol
//	}

	public void generarClusters(Integer cantidad) {
		// TODO Auto-generated method stub
	}

//	public HashMap<String, Point> getListaVertices() {
//		return listaVertices;
//	}

}
