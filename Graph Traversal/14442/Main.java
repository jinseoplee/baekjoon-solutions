import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int n, m, k;
	static char[][] map;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Position {
		int r, c, distance, breakCnt;

		Position(int r, int c, int distance, int breakCnt) {
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.breakCnt = breakCnt;
		}
	}

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	// 최단 거리를 반환한다.
	static int getShortestDistance() {
		Queue<Position> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[k + 1][n][m];
		q.offer(new Position(0, 0, 1, 0));
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
				if (curr.breakCnt == k && map[nextR][nextC] == '1') continue;
				if (map[nextR][nextC] == '0' && !visited[curr.breakCnt][nextR][nextC]) {
					q.offer(new Position(nextR, nextC, curr.distance + 1, curr.breakCnt));
					visited[curr.breakCnt][nextR][nextC] = true;
				} else if (map[nextR][nextC] == '1' && !visited[curr.breakCnt + 1][nextR][nextC]) {
					q.offer(new Position(nextR, nextC, curr.distance + 1, curr.breakCnt + 1));
					visited[curr.breakCnt + 1][nextR][nextC] = true;
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
		k = Integer.parseInt(input[2]);

		// 맵 초기화
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 최단 거리를 출력한다.
		System.out.println(getShortestDistance());
	}
}