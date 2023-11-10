import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };

	static boolean inRange(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int dir = 0; dir < 8; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (inRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
				dfs(nextR, nextC);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// w와 h가 모두 0이면 테스트를 종료한다.
			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];

			// 지도 초기화
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 섬의 개수를 구한다.
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}