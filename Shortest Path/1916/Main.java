import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

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

	static int dijkstra(int from, int to) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] cost = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(cost, Integer.MAX_VALUE);

		pq.offer(new Node(from, 0));
		cost[from] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.v]) continue;
			if (curr.v == to) break;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (cost[next.v] > cost[curr.v] + next.cost) {
					cost[next.v] = cost[curr.v] + next.cost;
					pq.add(new Node(next.v, cost[next.v]));
				}
			}
		}

		return cost[to];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 초기화
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 단방향 그래프
			graph.get(from).add(new Node(to, cost));
		}

		// 출발점과 도착점을 입력받는다.
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		// 최소 비용을 출력한다.
		System.out.println(dijkstra(from, to));
	}
}