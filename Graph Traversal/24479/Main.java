import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r;
	static int order = 1;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;

	static void dfs(int v) {
		// 방문 배열에 방문 순서를 저장
		visited[v] = order;

		for (int next : graph.get(v)) {
			// 아직 방문하지 않은 경우 탐색 수행
			if (visited[next] == 0) {
				order++;
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder orderOfVisit = new StringBuilder();

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

		// 간선 정보 처리
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			// 무방향 그래프
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		// 오름차순으로 방문하기 위해서 정렬 수행
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(r);

		// 방문 순서 출력
		for (int i = 1; i <= n; i++) {
			orderOfVisit.append(visited[i]).append("\n");
		}
		System.out.println(orderOfVisit);
	}
}