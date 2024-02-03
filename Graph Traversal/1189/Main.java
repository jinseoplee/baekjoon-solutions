import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K, ans;
	static char[][] map;
	static boolean[][] visited;

	// 상, 하, 좌, 우
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	static boolean inRange(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static void dfs(int r, int c, int k) {
		if (r == 0 && c == C - 1) {
			if (k == K) ans++;
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (!inRange(nextR, nextC) || visited[nextR][nextC]) continue;
			if (map[nextR][nextC] == '.' && k + 1 <= K) {
				visited[nextR][nextC] = true;
				dfs(nextR, nextC, k + 1);
				visited[nextR][nextC] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited[R - 1][0] = true;
		dfs(R - 1, 0, 1);
		System.out.println(ans);
	}
}