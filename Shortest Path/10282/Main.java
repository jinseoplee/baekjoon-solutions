import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, d, c;
	static int[] time;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;

	static class Node implements Comparable<Node> {
		int v, time;

		Node(int v, int time) {
			this.v = v;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	static void dijkstra(int src) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(src, 0));
		time[src] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.v]) continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (time[next.v] > time[curr.v] + next.time) {
					time[next.v] = time[curr.v] + next.time;
					pq.add(new Node(next.v, time[next.v]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			time = new int[n + 1];
			visited = new boolean[n + 1];

			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
				time[i] = Integer.MAX_VALUE;
			}

			// 간선 초기화
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				// 단방향 그래프
				graph.get(b).add(new Node(a, s));
			}

			dijkstra(c);

			int cnt = 0;// 총 감염되는 컴퓨터 수
			int elapsedTime = 0; // 마지막 컴퓨터가 감염되기까지 걸리는 시간
			for (int i = 1; i <= n; i++) {
				if (time[i] != Integer.MAX_VALUE) {
					cnt++;
					elapsedTime = Math.max(elapsedTime, time[i]);
				}
			}
			answer.append(cnt).append(" ").append(elapsedTime).append("\n");
		}
		System.out.println(answer);
	}
}