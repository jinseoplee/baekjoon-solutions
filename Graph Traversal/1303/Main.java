import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static int wPower, bPower;
	static char[][] map;
	static boolean[][] visited;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < m && 0 <= c && c < n;
	}

	// dfs로 아군의 수 계산
	static int dfs(int r, int c, char color) {
		// 방문 처리
		visited[r][c] = true;
		int cnt = 1; // 아군의 수 초기화

		// 사방 탐색
		for (int dir = 0; dir < 4; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (inRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == color) {
				cnt += dfs(nextR, nextC, color);
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]); // 가로
		m = Integer.parseInt(input[1]); // 세로

		map = new char[m][];
		for (int i = 0; i < m; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new boolean[m][n];

		// w와 b의 위력을 구한다.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					int cnt = dfs(i, j, map[i][j]);
					if (map[i][j] == 'W') {
						wPower += (cnt * cnt);
					} else {
						bPower += (cnt * cnt);
					}
				}
			}
		}

		// 아군과 적국의 위력을 출력한다.
		System.out.println(wPower + " " + bPower);
	}
}