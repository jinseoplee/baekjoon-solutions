import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r;
	static int maxItemCnt;
	static int[] item, dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int v, dist;

		Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

	static void dijkstra(int src) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(src, 0));
		dist[src] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.v]) continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (dist[next.v] > dist[curr.v] + next.dist) {
					dist[next.v] = dist[curr.v] + next.dist;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

	// 수색 범위 이내에 습득 가능한 아이템의 개수를 반환한다.
	static int getItemCnt() {
		int itemCnt = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] != Integer.MAX_VALUE && dist[i] <= m) {
				itemCnt += item[i];
			}
		}
		return itemCnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		item = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 초기화
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			// 양방향 그래프
			graph.get(a).add(new Node(b, d));
			graph.get(b).add(new Node(a, d));
		}

		dist = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			dijkstra(i);
			maxItemCnt = Math.max(maxItemCnt, getItemCnt());
		}

		System.out.println(maxItemCnt);
	}
}