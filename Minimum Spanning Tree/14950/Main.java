import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal 알고리즘을 이용하여 모든 도시를 정복하는 데 사용되는 최소 비용을 구한다. 
 * 시작 도시는 반드시 1번 도시여야 한다.
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
			return cost - o.cost;
		}
	}

	static int n, m, t, minCost;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

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

	static int calcMinCost() {
		int conquestCnt = 1;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (find(curr.a) != find(curr.b)) {
				union(curr.a, curr.b);
				minCost += curr.cost + t * conquestCnt++;
			}
		}
		return minCost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		// 처음 정복할 도시와 비용
		int firstV = 0;
		int firstCost = 10001;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, cost));

			// 처음 정복할 도시와 비용을 구한다.
			if (a == 0 && cost < firstCost) {
				firstCost = cost;
				firstV = b;
			}
		}

		makeSet();

		// 처음 도시를 정복하는데 필요한 비용을 더한다.
		minCost = firstCost;

		// 처음 정복한 도시를 0번 도시와 같은 집합으로 표현한다.
		parent[firstV] = 0;

		// Kruskal 알고리즘을 이용하여 최소 비용을 구한다.
		System.out.println(calcMinCost());
	}
}