import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] graph;
	static int[][] visited;

	static void dfs(int startV, int currV) {
		for (int i = 0; i < n; i++) {
			if (graph[currV][i] == 1 && visited[startV][i] == 0) {
				visited[startV][i] = 1;
				dfs(startV, i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			dfs(i, i);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(visited[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}