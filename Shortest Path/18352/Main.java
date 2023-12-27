import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, x;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] dist;

	static class Node {
		int v, cost;

		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		boolean[] visited = new boolean[n + 1];
		pq.add(new Node(x, 0));
		dist[x] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.v]) continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (dist[next.v] > dist[curr.v] + next.cost) {
					dist[next.v] = dist[curr.v] + next.cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		dist = new int[n + 1];

		// 그래프와 최단거리 배열 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}

		// 간선 초기화
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 단방향 그래프
			graph.get(u).add(new Node(v, 1));
		}

		dijkstra();

		// 최단 거리가 k인 도시를 출력한다.
		boolean isExist = false;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == k) {
				System.out.println(i);
				isExist = true;
			}
		}

		// 최단 거리가 k인 도시가 하나도 없으면 -1을 출력한다.
		if (!isExist) {
			System.out.println(-1);
		}
	}
}