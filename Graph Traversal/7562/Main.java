import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, srcX, srcY, dstX, dstY;
	static int[][] grid;
	static Queue<Pair> q;
	static int[][] visited;

	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	static void bfs(int x, int y) {
		while (!q.isEmpty()) {
			Pair curr = q.poll();

			if (curr.x == dstX && curr.y == dstY) {
				break;
			}

			for (int dir = 0; dir < 8; dir++) {
				int nextX = curr.x + dx[dir];
				int nextY = curr.y + dy[dir];
				if (inRange(nextX, nextY) && visited[nextX][nextY] == 0) {
					visited[nextX][nextY] = visited[curr.x][curr.y] + 1;
					q.offer(new Pair(nextX, nextY));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			grid = new int[n][n];
			visited = new int[n][n];

			// 시작점
			st = new StringTokenizer(br.readLine());
			srcX = Integer.parseInt(st.nextToken());
			srcY = Integer.parseInt(st.nextToken());

			// 도착점
			st = new StringTokenizer(br.readLine());
			dstX = Integer.parseInt(st.nextToken());
			dstY = Integer.parseInt(st.nextToken());

			q = new ArrayDeque<>();
			q.offer(new Pair(srcX, srcY));
			bfs(srcX, srcY);
			sb.append(visited[dstX][dstY]).append("\n");
		}
		System.out.println(sb);
	}
}