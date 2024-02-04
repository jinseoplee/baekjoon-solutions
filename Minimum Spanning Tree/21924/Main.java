import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal 알고리즘을 이용하여 모든 건물을 연결하는 도로의 최소 비용을 구한다. 
 * 모든 도로를 설치하는 비용에 최소 비용을 빼서 절약하는 비용을 구한다.
 *
 */
public class Main {
	static class Edge implements Comparable<Edge> {
		int a, b;
		long cost;

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

	static int n, m;
	static long totalCost, edgeCount;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static void makeSet() {
		parent = new int[n];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}
	}

	static int find(int i) {
		if (i == parent[i]) return i;
		return parent[i] = find(parent[i]);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		if (a > b) parent[a] = b;
		else parent[b] = a;
		return true;
	}

	static long kruskal() {
		long minCost = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (union(curr.a, curr.b)) {
				minCost += curr.cost;
				// 모든 건물이 연결되어 있는 경우
				if (++edgeCount == n - 1) {
					// 절약할 수 있는 비용을 반환한다.
					return totalCost - minCost;
				}
			}
		}
		// 모든 건물이 연결되어 있지 않은 경우
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			totalCost += cost;
			pq.offer(new Edge(a, b, cost));
		}

		makeSet();

		System.out.println(kruskal());
	}
}