import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal 알고리즘을 이용하여 별자리를 만드는 최소 비용을 구한다. 
 * 각 별의 x, y 좌표를 입력을 받고 모든 별 사이의 거리를 계산하여 최소 비용으로 연결한다.
 * 
 */
public class Main {
	static int n, startCnt;
	static int[] parent;
	static double minCost;
	static double[][] location;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

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

	static double getCost(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}

	static void makeSet() {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		location = new double[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.valueOf(st.nextToken());
			double y = Double.valueOf(st.nextToken());
			location[i][0] = x;
			location[i][1] = y;
		}

		makeSet();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				pq.offer(new Edge(i, j, getCost(location[i][0], location[i][1], location[j][0], location[j][1])));
			}
		}

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.a, edge.b)) {
				minCost += edge.cost;
				if (++startCnt == n - 1) break;
			}
		}

		System.out.println(String.format("%.2f", minCost));
	}
}