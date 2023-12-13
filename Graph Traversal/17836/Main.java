import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, t;
	static int[][] map;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Hero {
		int r, c, t;
		boolean hasGram;

		Hero(int r, int c, int t, boolean hasGram) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.hasGram = hasGram;
		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static String bfs() {
		Queue<Hero> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[2][n][m];
		q.offer(new Hero(0, 0, 0, false));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Hero curr = q.poll();

			// 공주를 t시간 이내로 구출하지 못하는 경우
			if (curr.t > t)
				break;

			// 공주가 있는 곳에 도착한 경우
			if (curr.r == n - 1 && curr.c == m - 1) {
				return String.valueOf(curr.t);
			}

			// 그람이 있는 곳에 도착한 경우
			if (map[curr.r][curr.c] == 2) {
				curr.hasGram = true;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];
				if (!inRange(nextR, nextC)) continue;
				if (visited[curr.hasGram ? 1 : 0][nextR][nextC]) continue;
				if (!curr.hasGram && map[nextR][nextC] == 1) continue;
				q.offer(new Hero(nextR, nextC, curr.t + 1, curr.hasGram));
				visited[curr.hasGram ? 1 : 0][nextR][nextC] = true;
			}
		}

		return "Fail";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}
}