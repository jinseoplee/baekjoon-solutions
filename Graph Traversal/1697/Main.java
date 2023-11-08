import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int src, dst, elapsedTime;
	static int[] visited = new int[100001];

	static boolean canGo(int x) {
		return 0 <= x && x < 100001 && visited[x] == 0;
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(src);
		visited[src] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();

			if (x == dst) {
				elapsedTime = visited[x] - 1;
				return;
			}

			if (canGo(x - 1)) {
				q.offer(x - 1);
				visited[x - 1] = visited[x] + 1;
			}

			if (canGo(x + 1)) {
				q.offer(x + 1);
				visited[x + 1] = visited[x] + 1;
			}

			if (canGo(x * 2)) {
				q.offer(x * 2);
				visited[x * 2] = visited[x] + 1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		src = Integer.parseInt(st.nextToken());
		dst = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(elapsedTime);
	}
}