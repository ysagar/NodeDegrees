package degree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utils.Graph;

/**
 * Calculates the degree of all the nodes
 * 
 * @author Yogesh
 */
public class NodeDegree {

	/**
	 * Prints the degree of each node in a graph
	 */
	public static void printDegreeOfEachNode(Graph g) {
		Objects.requireNonNull(g);
		Map<Integer, Integer> resultsMap = degrees(g);
		for (Map.Entry<Integer, Integer> entry : resultsMap.entrySet()) {
			if (entry.getKey() != 0) {
				System.out.printf("Node %d has degree of %d\n", entry.getKey(), entry.getValue());
			}
		}
	}

	private static Map<Integer, Integer> degrees(Graph g) {
		Map<Integer, Integer> results = new HashMap<>();
		for (int i = 0; i < g.getNumVertices(); i++) {
			results.put(i, degree(g, i));
		}
		return results;
	}

	private static int degree(Graph g, int v) {
		int degree = 0;
		for (int w : g.adjacent(v)) {
			degree++;
		}
		return degree;
	}

}
