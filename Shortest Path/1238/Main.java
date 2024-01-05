import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;

	static class Node implements Comparable<Node> {
		int v, weight;

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static int[] dijkstra(int start, int n, ArrayList<ArrayList<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		boolean[] visited = new boolean[n + 1];

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.v]) continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (dist[next.v] > dist[curr.v] + next.weight) {
					dist[next.v] = dist[curr.v] + next.weight;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점의 수 - 마을
		int m = Integer.parseInt(st.nextToken()); // 간선의 수 - 도로
		int x = Integer.parseInt(st.nextToken()); // 파티를 벌이는 마을

		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		ArrayList<ArrayList<Node>> reverse = new ArrayList<>();

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}

		// 간선 초기화
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작점
			int e = Integer.parseInt(st.nextToken()); // 끝점
			int w = Integer.parseInt(st.nextToken()); // 시간

			graph.get(s).add(new Node(e, w));
			reverse.get(e).add(new Node(s, w));
		}

		int[] dist1 = dijkstra(x, n, graph); // 시작점 x에서 다른 모든 정점으로의 최단 거리 - 돌아오는 길
		int[] dist2 = dijkstra(x, n, reverse); // 모든 정점에서 시작점 x로의 최단 거리 - 가는 길

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, dist1[i] + dist2[i]);
		}
		System.out.println(answer);
	}
}