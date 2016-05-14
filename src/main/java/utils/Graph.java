package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a Undirected graph.
 * 
 * Adjacency list are not 0 based
 * 
 * @author Yogesh
 */
public class Graph {

	/** Number of vertices */
	private final int numVertices;
	/** Number of Edges */
	private int numEdges;
	/** Adjacency list */
	private List<Integer>[] adjList;

	@SuppressWarnings("unchecked")
	public Graph(int numVertices) {
		if (numVertices <= 0) {
			throw new IllegalArgumentException("Number of vertices must be greater than 0");
		}
		this.numVertices = numVertices + 1;
		adjList = (List<Integer>[]) new List[this.numVertices];
		for (int i = 0; i < this.numVertices; i++) {
			adjList[i] = new ArrayList<Integer>();

		}
	}

	public Graph(In in) {
		this(in.readInt());
		while (in.hasNextLine()) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	/**
	 * Adds the edge onto the Graph
	 * 
	 * @param v
	 *            source vertex
	 * @param w
	 *            dest vertex
	 */
	public void addEdge(int v, int w) {
		checkRange(v, w);
		this.adjList[v].add(w);
		this.adjList[w].add(v);
		this.numEdges++;
	}

	/**
	 * Validates the range
	 */
	private void checkRange(int v, int w) {
		checkRangeFor(v);
		checkRangeFor(w);
	}
	
	/**
	 * Validates the ranfor for specified index
	 */
	private void checkRangeFor(int v) {
		if (v <= 0 || v > this.numVertices) {
			throw new IllegalArgumentException("Vertex " + v + " is not in valid range");
		}
	}

	/**
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return numVertices - 1;
	}

	/**
	 * 
	 * @return the number of edges in the graph
	 */
	public int getNumEdges() {
		return numEdges;
	}

	/**
	 * Returns the adjacency list for specified vertex
	 * @param v the vertex
	 */
	public Iterable<Integer> adjacent(int v) {
		return this.adjList[v];
	}
}
