import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, maxHeight;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void dfs(int x, int y, int h) {
		visited[x][y] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if ((0 <= nextX && nextX < n && 0 <= nextY && nextY < n) 
					&& !visited[nextX][nextY]
					&& map[nextX][nextY] > h) {
				dfs(nextX, nextY, h);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		int maxSafeArea = 0;
		for (int h = 0; h <= maxHeight; h++) {
			visited = new boolean[n][n];
			int safeArea = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						dfs(i, j, h);
						safeArea++;
					}
				}
			}
			maxSafeArea = Math.max(maxSafeArea, safeArea);
		}

		System.out.println(maxSafeArea);
	}
}