import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static int[][] map;
	static boolean isTop;
	static boolean[][] visited;

	// 팔방 탐색
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int dir = 0; dir < 8; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (!inRange(nextR, nextC)) continue;
			
			// 인접한 칸에 더 높은 봉우리가 있는 경우
			if (map[nextR][nextC] > map[r][c]) isTop = false;
			if (visited[nextR][nextC] || map[nextR][nextC] != map[r][c]) continue;
			dfs(nextR, nextC);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 맵 초기화
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 산봉우리 개수를 구한다.
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					isTop = true;
					dfs(i, j);
					if (isTop) cnt++;
				}
			}
		}

		// 산봉우리 개수를 출력한다.
		System.out.println(cnt);
	}
}