import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v, e, p;
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

	static int dijkstra(int from, int to) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));

		int[] dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[from] = 0;

		boolean[] visited = new boolean[v + 1];

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.v == to) break;
			if (visited[curr.v])
				continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (dist[next.v] > dist[curr.v] + next.weight) {
					dist[next.v] = dist[curr.v] + next.weight;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}

		return dist[to];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken()); // 정점의 개수
		e = Integer.parseInt(st.nextToken()); // 간선의 개수
		p = Integer.parseInt(st.nextToken()); // 건우가 위치한 정점

		// 그래프 초기화
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 초기화
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 양방향 그래프
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		// 출발지 - 마산까지 최단 거리
		int dist1 = dijkstra(1, v);

		// 출발지 - 건우 - 마산까지 최단 거리
		int dist2 = dijkstra(1, p);
		dist2 += dijkstra(p, v);

		System.out.println(dist1 >= dist2 ? "SAVE HIM" : "GOOD BYE");
	}
}