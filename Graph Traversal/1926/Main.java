import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] visited;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	// dfs로 그림의 넓이를 구한다.
	static int dfs(int r, int c) {
		visited[r][c] = true;
		int cnt = 1;

		for (int dir = 0; dir < 4; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (inRange(nextR, nextC) && !visited[nextR][nextC]) {
				cnt += dfs(nextR, nextC);
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				visited[i][j] = Integer.parseInt(st.nextToken()) == 1 ? false : true;
			}
		}

		int cnt = 0; // 그림의 개수
		int maxArea = 0; // 가장 넓은 그림의 넓이
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					int area = dfs(i, j);
					maxArea = Math.max(maxArea, area);
					cnt++;
				}
			}
		}

		System.out.println(cnt + "\n" + maxArea);
	}
}