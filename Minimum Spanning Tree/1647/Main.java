import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Kruskal 알고리즘을 이용하여 유지비 합의 최솟값을 구한다. 
 * 두 개의 마을로 분할하기 위해 가장 큰 비용의 도로를 합에서 뺀다.
 *
 */
public class Main {
	static int n, m;
	static int roadCnt, sum, maxCost;
	static int[] parent;
	static PriorityQueue<Road> pq = new PriorityQueue<>();

	static class Road implements Comparable<Road> {
		int a, b, cost;

		Road(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
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
		if (a == b) return false; // 사이클이 발생한 경우
		if (a > b) parent[a] = b;
		else parent[b] = a;
		return true;
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
			pq.offer(new Road(a, b, cost));
		}

		makeSet();

		for (int i = 0; i < m; i++) {
			Road road = pq.poll();
			if (union(road.a, road.b)) {
				maxCost = Math.max(maxCost, road.cost);
				sum += road.cost;
				if (++roadCnt == n - 1) break;
			}
		}

		System.out.println(sum - maxCost);
	}
}