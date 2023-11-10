import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] graph;
	static boolean[] visited;

	static void dfs(int v) {
		visited[v] = true;
		for (int i = 1; i <= n; i++) {
			if (graph[v][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
		}

		// 연결 요소의 개수를 구한다.
		visited = new boolean[n + 1];
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}