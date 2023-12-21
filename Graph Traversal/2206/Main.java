import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int n, m;
	static char[][] map;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Position {
		int r, c, distance;
		boolean hasBroken; // 벽을 부순 적이 있는지

		Position(int r, int c, int distance, boolean hasBroken) {
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.hasBroken = hasBroken;
		}
	}

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static int getShortestDistance() {
		Queue<Position> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[2][n][m];
		q.offer(new Position(0, 0, 1, false));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Position curr = q.poll();

			if (curr.r == n - 1 && curr.c == m - 1) {
				return curr.distance;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];
				if (!inRange(nextR, nextC)) continue;
				if (visited[curr.hasBroken ? 1 : 0][nextR][nextC]) continue;
				if (curr.hasBroken && map[nextR][nextC] == '1') continue;
				if (!curr.hasBroken && map[nextR][nextC] == '1') {
					q.offer(new Position(nextR, nextC, curr.distance + 1, true));
				} else {
					q.offer(new Position(nextR, nextC, curr.distance + 1, curr.hasBroken));
					visited[curr.hasBroken ? 1 : 0][nextR][nextC] = true;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new char[n][];

		// 맵 초기화
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		System.out.println(getShortestDistance());
	}
}