import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal 알고리즘을 이용하여 모든 컴퓨터를 연결하는데 필요한 최소비용을 구한다.
public class Main {
	static int n, m;
	static int connectionCount, minCost;
	static int[] parent;
	static PriorityQueue<Connection> pq = new PriorityQueue<>();

	static class Connection implements Comparable<Connection> {
		int a, b, cost;

		Connection(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Connection c) {
			return this.cost - c.cost;
		}
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
		if (a == b) return false; // 사이클이 발생하는 경우
		if (a > b) parent[a] = b;
		else parent[b] = a;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Connection(a, b, cost));
		}

		makeSet();

		for (int i = 0; i < m; i++) {
			Connection connection = pq.poll();
			if (union(connection.a, connection.b)) {
				minCost += connection.cost;
				if (++connectionCount == n - 1) break;
			}
		}

		System.out.println(minCost);
	}
}