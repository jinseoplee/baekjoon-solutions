import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] parent;
	static List<Edge> edges = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 건물의 개수
		m = Integer.parseInt(st.nextToken()); // 도로의 개수

		for (int i = 0; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 건물 a
			int b = Integer.parseInt(st.nextToken()); // 건물 b
			int c = Integer.parseInt(st.nextToken()); // 오르막길 또는 내리막길
			edges.add(new Edge(a, b, c));
		}

		Collections.sort(edges, Collections.reverseOrder());
		int bestCost = calcFatigue();

		Collections.sort(edges);
		int worstCost = calcFatigue();

		System.out.println(worstCost - bestCost);
	}

	static void makeSet() {
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}

	static int calcFatigue() {
		makeSet();

		int fatigue = 0;
		int edgeCount = 0;
		for (Edge edge : edges) {
			if (find(edge.a) != find(edge.b)) {
				union(edge.a, edge.b);
				if (edge.c == 0) fatigue++;
				edgeCount++;
			}

			if (edgeCount == n) break;
		}

		return fatigue * fatigue;
	}
}

class Edge implements Comparable<Edge> {
	int a, b, c;

	Edge(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public int compareTo(Edge o) {
		return c - o.c;
	}
}