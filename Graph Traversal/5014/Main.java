import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int f, s, g, u, d;
	static String ans = "use the stairs";
	static int[] visited;

	static boolean canGo(int floor) {
		return 1 <= floor && floor <= f && visited[floor] == 0;
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(s);
		visited[s] = 1;

		while (!q.isEmpty()) {
			int curr = q.poll();

			if (curr == g) {
				ans = String.valueOf(visited[curr] - 1);
				return;
			}

			if (canGo(curr + u)) {
				q.offer(curr + u);
				visited[curr + u] = visited[curr] + 1;
			}

			if (canGo(curr - d)) {
				q.offer(curr - d);
				visited[curr - d] = visited[curr] + 1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		visited = new int[f + 1];
		bfs();
		System.out.println(ans);
	}
}