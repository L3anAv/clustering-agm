package clusteringAGM;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
	
	private Grafo grafoTest;
	
	public GrafoTest() {
		grafoTest = new Grafo();
	}

	@Before
	public void seteoGrafoParaTest() throws Exception {
		grafoTest.insertarVertice("A", 5.0, 5.0);
		grafoTest.insertarVertice("B", 7.0, 10.0);
		grafoTest.insertarVertice("C", 12.0, 7.0);
		grafoTest.insertarVertice("D", 6.0, 1.0);
	}
	
	@Test /* Testeando si existe un vertice en el grafo. */
	public void testExisteVerticeTrue() {
		assertTrue(grafoTest.existeVertice("C"));
	}
	
	@Test /* Testeando si existe un vertice en el grafo. */
	public void testExisteVerticeFalse() {
		assertFalse(grafoTest.existeVertice("E"));
	}
	
	@Test /* Testeando que ingresese un vertice al grafo. */
	public void insertaVerticeGrafoDistintosTrue(){
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		
		try {
			grafoTest.insertarVertice("E", coordenadaX, coordenadaY);
			grafoTest.insertarVertice("F", coordenadaX, coordenadaY);
			assertTrue(grafoTest.getCantidadDeVertices() == 6);
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test /* Testeando que ingresese un vertice al grafo. */
	public void insertaVerticeGrafoDistintosFalse(){
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		
		try {
			grafoTest.insertarVertice("E", coordenadaX, coordenadaY);
			grafoTest.insertarVertice("F", coordenadaX, coordenadaY);
			assertFalse(grafoTest.getCantidadDeVertices() != 6);
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test(expected = Exception.class) /* Testeando que ingresese dos vertices iguales al grafo
	 y da la exepcion correspondiente. */
	public void testInsertaVerticeGrafoIguales() throws Exception{
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		
		grafoTest.insertarVertice("B",coordenadaX, coordenadaY);
		grafoTest.insertarVertice("B",coordenadaX, coordenadaY);
	}

	@Test /* Testeo de creacion de arista */
	public void crearNuevaAristaTrue() {
		
		LinkedList<Vertice> vertices = grafoTest.getVerticesGrafo();
		Vertice vertice1 =  vertices.get(0);
		Vertice vertice2 =  vertices.get(1);
		
		grafoTest.crearNuevaArista(vertice1, vertice2);
		LinkedList<Arista> aristas =  grafoTest.getListaAristas();
		
		assertTrue(aristas.size() == 1);
	}
	
	@Test /* Testeo de metodo de unir grafo sirve (Creacion de aristas) */
	public void testUnirGrafoTrue() {
		
		grafoTest.CrearGrafo();
		LinkedList<Arista> listaDeAristas = grafoTest.getListaAristas();
		assertTrue(listaDeAristas.size() == 6);
		
	}
	
	@Test /* Testeo de la eliminacion de arista del grafo */
	public void testUnirGrafoAristaABExisteTrue() {
		
		grafoTest.CrearGrafo();
		LinkedList<Arista> listaDeAristas = grafoTest.getListaAristas();
		
		Arista arista = listaDeAristas.get(0);
		
		Vertice vertice1 = arista.getVertice1Artista();
		Vertice vertice2 = arista.getVertice2Artista();
		
		assertTrue(vertice1.getNombre().equals("A") && vertice2.getNombre().equals("B"));
	}
	
	@Test /* Testeo de la eliminacion de arista del grafo */
	public void testEliminarAristaDeGrafoExistosa(){
		
		LinkedList<Vertice> vertices = grafoTest.getVerticesGrafo();
		grafoTest.CrearGrafo();
		grafoTest.eliminarArista(0);
		
		assertFalse(grafoTest.existeAristaEnGrafo(vertices.get(0), vertices.get(1)));
	}
	
	/* Testeo de metodo que transforma grafo a arbol generador Minimo */
	@Test
	public void testTransformarArbolGeneradorMinimo() {
		grafoTest.CrearGrafo();
		grafoTest.transformarArbolGeneradorMinimo();
		assertTrue(grafoTest.getListaAristas().get(0).getPeso() == 4.123105625617661);
		assertTrue(grafoTest.getListaAristas().get(1).getPeso() == 5.385164807134504);
		assertTrue(grafoTest.getListaAristas().get(2).getPeso() == 5.830951894845301);
		assertTrue(grafoTest.getListaAristas().size() == 3);
		assertTrue(grafoTest.getVerticesGrafo().size() == 4);
	}
}
