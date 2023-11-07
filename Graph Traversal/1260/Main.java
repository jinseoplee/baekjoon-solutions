import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, v;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	// 방문 배열 초기화
	static void initialize() {
		Arrays.fill(visited, false);
	}

	static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");

		for (int nextV : graph.get(v)) {
			if (!visited[nextV]) {
				dfs(nextV);
			}
		}
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;
		sb.append(v).append(" ");

		while (!q.isEmpty()) {
			int currV = q.poll();
			for (int nextV : graph.get(currV)) {
				if (!visited[nextV]) {
					visited[nextV] = true;
					q.offer(nextV);
					sb.append(nextV).append(" ");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		visited = new boolean[n + 1];

		// 정점 번호가 작은 것부터 먼저 방문할 수 있도록 정렬 수행
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(v);
		sb.append("\n");
		initialize();
		bfs();

		System.out.println(sb);
	}
}