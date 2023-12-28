import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] cost;

	static class Node implements Comparable<Node> {
		int v, cost;

		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		pq.add(new Node(1, 0));
		cost[1] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.v]) continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (cost[next.v] > cost[curr.v] + next.cost) {
					cost[next.v] = cost[curr.v] + next.cost;
					pq.add(new Node(next.v, cost[next.v]));
				}
			}
		}

		return cost[n];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		cost = new int[n + 1];

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			cost[i] = Integer.MAX_VALUE;
		}

		// 간선 초기화
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 양방향 그래프
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		// 여물의 최소 비용을 출력한다.
		System.out.println(dijkstra());
	}
}