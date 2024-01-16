import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] cost, route;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int v, cost;

		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}

	static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		cost = new int[n + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;

		route = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.v == end) break;
			if (visited[curr.v]) continue;

			visited[curr.v] = true;
			for (Node next : graph.get(curr.v)) {
				if (cost[next.v] > cost[curr.v] + next.cost) {
					cost[next.v] = cost[curr.v] + next.cost;
					pq.offer(new Node(next.v, cost[next.v]));
					route[next.v] = curr.v;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine()); // 도시의 개수
		m = Integer.parseInt(br.readLine()); // 버스의 개수

		for (int i = 0; i <= n; i++) { // 그래프 초기화
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
			int e = Integer.parseInt(st.nextToken()); // 도착 도시의 번호
			int cost = Integer.parseInt(st.nextToken()); // 비용
			graph.get(s).add(new Node(e, cost));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()); // 출발점
		int e = Integer.parseInt(st.nextToken()); // 도착점

		dijkstra(s, e);
		sb.append(cost[e]).append("\n"); // 출발점 - 도착점 최소 비용

		Stack<Integer> stack = new Stack<>();
		stack.push(e);
		while (route[e] != 0) {
			stack.push(route[e]);
			e = route[e];
		}

		sb.append(stack.size()).append("\n"); // 최소 비용을 갖는 경로에 포함되어 있는 도시의 개수
		while (!stack.isEmpty()) { // 도시의 순서
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb); // 결과 출력
	}
}