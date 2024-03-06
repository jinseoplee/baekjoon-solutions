import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int u, v, w;

	Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return w - o.w;
	}
}

public class Main {
	static int n, m, k;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		makeSet();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			parent[Integer.parseInt(st.nextToken())] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(u, v, w));
		}

		System.out.println(findMinCost());
	}

	static void makeSet() {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	static int find(int u) {
		if (u == parent[u]) return u;
		return parent[u] = find(parent[u]);
	}

	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if (u > v) parent[u] = v;
		else parent[v] = u;
	}

	static int findMinCost() {
		int minCost = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (find(curr.u) != find(curr.v)) {
				union(curr.u, curr.v);
				minCost += curr.w;
			}
		}
		return minCost;
	}
}