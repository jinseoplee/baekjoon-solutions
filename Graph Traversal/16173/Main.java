import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;

	// 우, 남
	static final int[] dr = { 0, 1 };
	static final int[] dc = { 1, 0 };

	static String bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		boolean[][] visited = new boolean[n][n];
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			// 도달한 경우
			if (curr[0] == n - 1 && curr[1] == n - 1) {
				return "HaruHaru";
			}

			for (int dir = 0; dir < 2; dir++) {
				int nr = curr[0] + (map[curr[0]][curr[1]] * dr[dir]);
				int nc = curr[1] + (map[curr[0]][curr[1]] * dc[dir]);
				if ((nr < 0 || nr >= n || nc < 0 || nc >= n) || visited[nr][nc]) continue;
				q.offer(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}

		// 도달할 수 없는 경우
		return "Hing";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}
}