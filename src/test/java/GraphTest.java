import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import degree.NodeDegree;
import utils.Graph;
import utils.In;

public class GraphTest {

	private static Graph smallGraph = null, largeGraph = null;

	@BeforeClass
	public static void init() {
		smallGraph = new Graph(new In("/tiny.txt"));
		largeGraph = new Graph(new In("/large.txt"));
	}

	@Test
	public void testForVertices() {
		Assert.assertEquals("Number of vertices", 3, smallGraph.getNumVertices());
		Assert.assertEquals("Number of vertices", 16, largeGraph.getNumVertices());
	}

	@Test
	public void testForEdges() {
		Assert.assertEquals("Number of vertices", 2, smallGraph.getNumEdges());
		Assert.assertEquals("Number of edges", 58, largeGraph.getNumEdges());
	}

	@Test()
	public void testForPrintDegrees() {
		System.out.println("Printing degrees of small graph");
		NodeDegree.printDegreeOfEachNode(smallGraph);

		System.out.println();

		System.out.println("Printing degrees of large graph");
		NodeDegree.printDegreeOfEachNode(largeGraph);
	}

	@Test(expected = RuntimeException.class)
	public void testForPrintDegreesWithInValidGraph() {
		NodeDegree.printDegreeOfEachNode(null);
	}

	@Test(expected = RuntimeException.class)
	public void testForInvalidVertices() {
		 new Graph(0);
	}
	
	@Test
	public void testForAddingEdges(){
		Graph g = new Graph(3);
		g.addEdge(1, 3);
		g.addEdge(2, 1);
		System.out.println("Printing the degrees of all nodes in the graph with "+g.getNumVertices()+" vertices");
		NodeDegree.printDegreeOfEachNode(g);
	}
	
	@Test(expected = RuntimeException.class)
	public void testForAddingInvalidEdges(){
		Graph g = new Graph(3);
		g.addEdge(1, 4);
		g.addEdge(2, 1);
	}
}
