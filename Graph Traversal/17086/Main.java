import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static Queue<Shark> q = new ArrayDeque<>();

	static class Shark {
		int r, c;

		Shark(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static int calcMaxSafeDistance() {
		int maxSafeDistance = 0;
		while (!q.isEmpty()) {
			Shark curr = q.poll();

			for (int dir = 0; dir < 8; dir++) {
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];
				if (inRange(nextR, nextC) && map[nextR][nextC] == 0) {
					q.offer(new Shark(nextR, nextC));
					map[nextR][nextC] = map[curr.r][curr.c] + 1;
					maxSafeDistance = map[nextR][nextC]; // 안전거리의 최댓값을 갱신한다.
				}
			}
		}

		return maxSafeDistance - 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					q.add(new Shark(r, c));
				}
			}
		}

		System.out.println(calcMaxSafeDistance());
	}
}