import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[][] arr;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if (inRange(nextX, nextY) && !visited[nextX][nextY] && arr[nextX][nextY] == arr[x][y]) {
				dfs(nextX, nextY);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// 보통 사람이 보는 그림의 구역 수
		int normalCnt = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					normalCnt++;
				}
			}
		}

		// 적록 색약자가 보는 그림으로 바꾼다.
		// 'R' -> 'G', 'G' -> 'R' 상관없음.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}

		// 적록 색약자가 보는 그림의 구역 수
		int colorBlindCnt = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					colorBlindCnt++;
				}
			}
		}

		System.out.println(normalCnt + " " + colorBlindCnt);
	}
}