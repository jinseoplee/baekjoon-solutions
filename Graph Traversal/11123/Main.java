import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int h, w, groupCount;
	static char[][] map;
	static boolean[][] visited;

	// 서, 동, 북, 남
	static final int[] dr = { 0, 0, -1, 1 };
	static final int[] dc = { -1, 1, 0, 0 };

	// 범위 체크
	static boolean inRange(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (inRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == '#') {
				dfs(nextR, nextC);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			// 세로, 가로 입력 처리
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			// 맵 초기화
			map = new char[h][];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}

			// 방문 배열 초기화
			visited = new boolean[h][w];
			groupCount = 0;

			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (!visited[r][c] && map[r][c] == '#') {
						dfs(r, c);
						groupCount++;
					}
				}
			}

			sb.append(groupCount).append("\n");
		}

		// 결과 출력
		System.out.println(sb);
	}
}