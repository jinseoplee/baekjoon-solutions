import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static class Pair {
		int r, c, cnt;

		Pair(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	static boolean inRange(int r, int c, int n) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	// 최소 이동 횟수를 구한다.
	static int getMinMoveCnt(int r1, int c1, int r2, int c2, int n) {
		Queue<Pair> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		q.offer(new Pair(r1, c1, 0));
		visited[r1][c1] = true;

		while (!q.isEmpty()) {
			Pair curr = q.poll();

			// r2, c2로 이동이 가능한 경우
			if (curr.r == r2 && curr.c == c2) {
				return curr.cnt;
			}

			for (int dir = 0; dir < 6; dir++) {
				int nextR = curr.r + dr[dir];
				int nextC = curr.c + dc[dir];
				if (inRange(nextR, nextC, n) && !visited[nextR][nextC]) {
					q.offer(new Pair(nextR, nextC, curr.cnt + 1));
					visited[nextR][nextC] = true;
				}
			}
		}

		// 이동할 수 없는 경우 -1을 리턴한다.
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		int r1 = Integer.parseInt(input[0]);
		int c1 = Integer.parseInt(input[1]);
		int r2 = Integer.parseInt(input[2]);
		int c2 = Integer.parseInt(input[3]);

		System.out.println(getMinMoveCnt(r1, c1, r2, c2, n));
	}
}