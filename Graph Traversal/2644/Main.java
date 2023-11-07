import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, src, dst;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;

	static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(src);
		visited[src] = 1;

		while (!q.isEmpty()) {
			int currV = q.poll();

			if (currV == dst) {
				return visited[currV] - 1;
			}

			for (int nextV : graph.get(currV)) {
				if (visited[nextV] == 0) {
					q.offer(nextV);
					visited[nextV] = visited[currV] + 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		src = Integer.parseInt(st.nextToken());
		dst = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		visited = new int[n + 1];

		System.out.println(bfs());
	}
}