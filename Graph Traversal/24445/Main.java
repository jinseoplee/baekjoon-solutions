import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r;
	static int order = 1;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;

	static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = order;

		while (!q.isEmpty()) {
			int currV = q.poll();
			for (int nextV : graph.get(currV)) {
				// 아직 방문하지 않은 경우 탐색 진행
				if (visited[nextV] == 0) {
					q.offer(nextV);
					visited[nextV] = ++order;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder orderOfVist = new StringBuilder();

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new int[n + 1];

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 정점 연결
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		// 정점을 내림차순으로 방문하기 위해 내림차순으로 정렬 수행
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}

		bfs(r);

		// 방문 순서 출력
		for (int i = 1; i <= n; i++) {
			orderOfVist.append(visited[i]).append("\n");
		}
		System.out.println(orderOfVist);
	}
}