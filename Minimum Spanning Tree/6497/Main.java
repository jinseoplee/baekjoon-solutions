import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal 알고리즘을 이용하여 MST를 구한다. 
 * 전체 비용에서 최소 비용을 빼서 절약할 수 있는 최대 비용을 구한다.
 *
 */
public class Main {
	static class Edge implements Comparable<Edge> {
		int x, y, cost;

		Edge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

	static int m, n, totalCost;
	static int[] parent;
	static PriorityQueue<Edge> pq;

	static void makeSet() {
		parent = new int[m];
		for (int i = 0; i < m; i++) {
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

	static int kruskal() {
		int minCost = 0;
		int count = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (union(curr.x, curr.y)) {
				minCost += curr.cost;
				if (++count == n - 1) break;
			}
		}
		return totalCost - minCost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (m == 0 && n == 0) break;

			totalCost = 0;
			pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				totalCost += z;
				pq.offer(new Edge(x, y, z));
			}

			makeSet();

			sb.append(kruskal()).append("\n");
		}

		System.out.println(sb);
	}
}