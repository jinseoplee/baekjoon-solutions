import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal 알고리즘을 이용하여 모든 대학교를 연결하는 최단 거리를 구한다. 
 * 단, 성별이 같은 대학교는 연결하지 않는다.
 *
 */
public class Main {
	static class Edge implements Comparable<Edge> {
		int u, v, d;

		Edge(int u, int v, int d) {
			this.u = u;
			this.v = v;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return d - o.d;
		}
	}

	static int n, m;
	static int[] parent;
	static char[] gender;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static void makeSet() {
		parent = new int[n];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}
	}

	static int find(int u) {
		if (u == parent[u]) return u;
		return parent[u] = find(parent[u]);
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
			if (gender[curr.u] != gender[curr.v] && union(curr.u, curr.v)) {
				minCost += curr.d;
				if (++count == n - 1) {
					return minCost;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		gender = new char[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			gender[i] = st.nextToken().charAt(0);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(u, v, d));
		}

		makeSet();

		System.out.println(kruskal());
	}
}