import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m;
	static int[][] map;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inRange(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= m;
	}

	static boolean canGo(int x, int y) {
		return inRange(x, y) && map[x][y] == 1;
	}

	static void bfs() {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(1, 1));

		while (!q.isEmpty()) {
			Pair curr = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nextX = curr.x + dx[dir];
				int nextY = curr.y + dy[dir];
				if (canGo(nextX, nextY)) {
					map[nextX][nextY] = map[curr.x][curr.y] + 1;
					q.offer(new Pair(nextX, nextY));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}

		bfs();

		System.out.println(map[n][m]);
	}
}