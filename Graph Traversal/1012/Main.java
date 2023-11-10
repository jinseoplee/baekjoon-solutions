import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[][] map;
	static boolean[][] visited;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static boolean inRange(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}

	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nextY = y + dy[dir];
			int nextX = x + dx[dir];
			if (inRange(nextY, nextX) && map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
				dfs(nextY, nextX);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 가로
			n = Integer.parseInt(st.nextToken()); // 세로
			int k = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 가로
				int y = Integer.parseInt(st.nextToken()); // 세로
				map[y][x] = 1;
			}

			visited = new boolean[n][m];
			int cnt = 0; // 배추흰지렁이 마리 수
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (!visited[y][x] && map[y][x] == 1) {
						dfs(y, x);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}