import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal 알고리즘을 이용하여 고속철도를 설치하는데 드는 최소 비용을 구한다.
 * 
 */
public class Main {
	static class Edge implements Comparable<Edge> {
		int a, b, cost;

		Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	static int n;
	static int minCost;
	static int[][] cost;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];

		makeSet();
		
		// 입력 처리
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				if (i >= j) continue;
				
				// 이미 설치된 고속도로를 같은 집합으로 표현하고 비용을 더한다.
				if (cost[i][j] < 0) {
					union(i, j);
					minCost += Math.abs(cost[i][j]);
				} else {
					pq.offer(new Edge(i, j, cost[i][j]));
				}
			}
		}

		solve();
	}

	static void solve() {
		StringBuilder sb = new StringBuilder();
		int newEdgeCnt = 0; // 새로 설치한 고속도로의 개수

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (find(curr.a) != find(curr.b)) {
				union(curr.a, curr.b);
				minCost += curr.cost;
				newEdgeCnt++;
				sb.append(curr.a + 1).append(" ").append(curr.b + 1).append("\n");
			}
		}

		System.out.println(minCost + " " + newEdgeCnt);
		System.out.println(sb);
	}

	static void makeSet() {
		parent = new int[n];
		for (int i = 1; i < n; i++) {
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
}