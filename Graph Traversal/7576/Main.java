import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x, y, day;

	Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class Main {
	static int n, m, unripeCnt, elapsedDay;
	static int[][] grid;
	static boolean[][] visited;

	static Queue<Tomato> q = new ArrayDeque<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static boolean canGo(int x, int y) {
		return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Tomato curr = q.poll();

			elapsedDay = Math.max(elapsedDay, curr.day);

			for (int dir = 0; dir < 4; dir++) {
				int nextX = curr.x + dx[dir];
				int nextY = curr.y + dy[dir];
				if (canGo(nextX, nextY)) {
					q.offer(new Tomato(nextX, nextY, curr.day + 1));
					visited[nextX][nextY] = true;
					unripeCnt--;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		grid = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int state = Integer.parseInt(st.nextToken());
				// 익지 않은 토마토인 경우
				if (state == 0) {
					unripeCnt++;
				}
				// 익은 토마토인 경우 큐에 삽입
				else if (state == 1) {
					q.offer(new Tomato(i, j, 0));
					visited[i][j] = true;
				}
				grid[i][j] = state;
			}
		}

		bfs();

		// 토마토가 모두 익지 못한 경우 -1을 출력하고, 모두 익은 경우 날짜를 출력한다.
		System.out.println(unripeCnt == 0 ? elapsedDay : -1);
	}
}