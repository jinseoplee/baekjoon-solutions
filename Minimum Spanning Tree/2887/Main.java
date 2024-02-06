import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int a, b; // 두 행성
		long cost; // 비용

		Edge(int a, int b, long cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(cost, o.cost);
		}
	}

	static int n;
	static int[] parent;
	static ArrayList<int[]> planets = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static void makeSet() {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		if (a > b) parent[a] = b;
		else parent[b] = a;
		return true;
	}

	static long calcMinCost() {
		long minCost = 0;
		int edgeCount = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (union(curr.a, curr.b)) {
				minCost += curr.cost;
				if (++edgeCount == n - 1) break;
			}
		}
		return minCost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planets.add(new int[] { i, x, y, z }); // {행성 번호, x, y, z}
		}

		for (int i = 1; i <= 3; i++) {
			int idx = i;
			Collections.sort(planets, (p1, p2) -> p1[idx] - p2[idx]);
			for (int j = 0; j < n - 1; j++) {
				pq.offer(new Edge(planets.get(j)[0], planets.get(j + 1)[0],
						Math.abs(planets.get(j)[idx] - planets.get(j + 1)[idx])));
			}
		}

		makeSet();

		System.out.println(calcMinCost());
	}
}