import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, m, cnt;
	static char[][] floor;
	static boolean[][] visited;

	// 북, 동, 남, 서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static void dfs(int r, int c) {
		// 방문 처리
		visited[r][c] = true;

		for (int dir = 0; dir < 4; dir++) {
			if (floor[r][c] == '-' && dir % 2 == 0) continue;
			if (floor[r][c] == '|' && dir % 2 == 1) continue;

			int nextR = r + dr[dir];
			int nextC = c + dc[dir];

			if (!inRange(nextR, nextC)) continue;
			if (visited[nextR][nextC]) continue;
			if (floor[nextR][nextC] != floor[r][c]) continue;
			dfs(nextR, nextC);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 가로와 세로를 입력받는다.
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		// 바닥 초기화
		floor = new char[n][];
		for (int i = 0; i < n; i++) {
			floor[i] = br.readLine().toCharArray();
		}

		// 바닥을 장식하는데 필요한 나무판자의 개수를 dfs를 이용하여 구한다.
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		// 필요한 나무판자의 개수를 출력한다.
		System.out.println(cnt);
	}
}