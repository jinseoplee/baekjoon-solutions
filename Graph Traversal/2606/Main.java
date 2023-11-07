import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, virusCnt;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;

	static void dfs(int v) {
		visited[v] = true;
		virusCnt++;

		for (int nextV : graph.get(v)) {
			if (!visited[nextV]) {
				dfs(nextV);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		visited = new boolean[n + 1];
		dfs(1);

		System.out.println(virusCnt - 1);
	}
}