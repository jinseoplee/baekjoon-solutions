import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 200_000_000;

	static int n, e;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int v, weight;

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);

		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.v == end) break;
			if (visited[curr.v]) continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (dist[next.v] > dist[curr.v] + next.weight) {
					dist[next.v] = dist[curr.v] + next.weight;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}

		return dist[end];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점의 수
		e = Integer.parseInt(st.nextToken()); // 간선의 수

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 초기화
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 무방향 그래프
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		dist = new int[n + 1];
		visited = new boolean[n + 1];

		// 거쳐가야 하는 두 정점
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		// 1 -> u -> v -> n;
		int path1 = 0;
		path1 += dijkstra(1, u);
		path1 += dijkstra(u, v);
		path1 += dijkstra(v, n);

		// 1 -> v -> u -> n;
		int path2 = 0;
		path2 += dijkstra(1, v);
		path2 += dijkstra(v, u);
		path2 += dijkstra(u, n);

		int result = Math.min(path1, path2);
		System.out.println(result >= INF ? -1 : result);
	}
}