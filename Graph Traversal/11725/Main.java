import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] visited;
	static ArrayList<Integer>[] tree;
	static Queue<Integer> q = new LinkedList<>();

	static void bfs() {
		while (!q.isEmpty()) {
			int parent = q.poll();
			for (int child : tree[parent]) {
				if (visited[child] == 0) {
					visited[child] = parent;
					q.offer(child);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		visited = new int[n + 1];
		tree = new ArrayList[n + 1];

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			if (tree[v1] == null) {
				tree[v1] = new ArrayList<>();
			}

			if (tree[v2] == null) {
				tree[v2] = new ArrayList<>();
			}

			tree[v1].add(v2);
			tree[v2].add(v1);
		}

		q.offer(1);
		visited[1] = 1;
		bfs();

		// 2번 노드부터 부모 노드 번호를 출력한다.
		for (int i = 2; i <= n; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
	}
}