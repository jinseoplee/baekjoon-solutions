import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int a, b;
		double cost;

		Edge(int a, int b, double cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}

	static int n, m;
	static int connectionCount;
	static int[][] god;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		god = new int[n][2];

		// 우주신들의 좌표를 입력받는다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			god[i][0] = x;
			god[i][1] = y;
		}

		makeSet();
		connectionCount = 0;

		// 이미 연결된 통로를 입력받는다.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			// a, b를 같은 집합으로 표현한다.
			if (union(a, b)) {
				connectionCount++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				pq.offer(new Edge(i, j, calcCost(i, j)));
			}
		}

		// 새로 만들어야 할 최소의 통로 길이를 구하고 출력한다.
		System.out.printf("%.2f", calcMinCost());
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

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		if (a > b) parent[a] = b;
		else parent[b] = a;
		return true;
	}

	// 통로의 길이(비용)를 계산한다.
	static double calcCost(int a, int b) {
		long dx = god[b][0] - god[a][0];
		long dy = god[b][1] - god[a][1];
		return Math.sqrt(dx * dx + dy * dy);
	}

	static double calcMinCost() {
		double minCost = 0.0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (union(curr.a, curr.b)) {
				minCost += curr.cost;
				if (++connectionCount == n - 1) break;
			}
		}
		return minCost;
	}
}