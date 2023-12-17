import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, m, cnt;
	static int startX, startY;
	static char[][] campus;
	static boolean[][] visited;

	// 상, 하, 좌, 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	static void dfs(int x, int y) {
		// 방문 처리
		visited[x][y] = true;

		// 사방 탐색
		for (int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if (!inRange(nextX, nextY)) continue;
			if (visited[nextX][nextY]) continue;
			if (campus[nextX][nextY] == 'X') continue;
			if (campus[nextX][nextY] == 'P') cnt++;
			dfs(nextX, nextY);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 캠퍼스의 가로와 세로 크기를 입력받는다.
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		// 캠퍼스 초기화
		campus = new char[n][];
		for (int i = 0; i < n; i++) {
			campus[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				// 도연이의 위치를 저장한다.
				if (campus[i][j] == 'I') {
					startX = i;
					startY = j;
				}
			}
		}

		visited = new boolean[n][m];

		// 도연이가 만날 수 있는 사람의 수를 구한다.
		dfs(startX, startY);

		// 결과 출력
		System.out.println(cnt == 0 ? "TT" : cnt);
	}
}