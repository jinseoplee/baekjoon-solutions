import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v, e;
	static int edgeCount, answer;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static class Edge implements Comparable<Edge> {
		int a, b, weight;

		Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static void makeSet() {
		parent = new int[v];
		for (int i = 0; i < v; i++) {
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, weight));
		}

		makeSet();

		// Kruskal 알고리즘을 이용하여 MST의 가중치를 구한다.
		for (int i = 0; i < e; i++) {
			Edge edge = pq.poll();
			if (union(edge.a, edge.b)) {
				answer += edge.weight;
				if (++edgeCount == v - 1) break;
			}
		}

		System.out.println(answer);
	}
}