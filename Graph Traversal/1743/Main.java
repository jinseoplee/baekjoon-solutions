import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int foodSize, maxFoodSize;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inRange(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= m;
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		foodSize++;
		for (int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if (inRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
				dfs(nextX, nextY);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		// k개의 음식물이 떨어진 좌표를 입력받는다.
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}

		visited = new boolean[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					foodSize = 0;
					dfs(i, j);
					maxFoodSize = Math.max(maxFoodSize, foodSize);
				}
			}
		}

		// 가장 큰 음식물의 크기를 출력한다.
		System.out.println(maxFoodSize);
	}
}