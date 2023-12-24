import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;

	// 하, 우
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	// (0, 0)에서 출발해서 (n - 1, n - 1)에 도착할 수 있는지 확인한다.
	static void bfs() {
		Queue<Pair> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		q.offer(new Pair(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Pair curr = q.poll();

			// (n - 1, n - 1)에 도착한 경우
			if (curr.r == n - 1 && curr.c == n - 1) {
				System.out.println("HaruHaru");
				return;
			}

			for (int dir = 0; dir < 2; dir++) {
				int nextR = curr.r + (map[curr.r][curr.c] * dr[dir]);
				int nextC = curr.c + (map[curr.r][curr.c] * dc[dir]);
				if (inRange(nextR, nextC) && !visited[nextR][nextC]) {
					q.offer(new Pair(nextR, nextC));
					visited[nextR][nextC] = true;
				}
			}
		}

		System.out.println("Hing");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());

		// 맵 초기화
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
	}
}