import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int m, n, k;
	static boolean[][] visited;
	static List<Integer> area = new ArrayList<>();

	// 상, 하, 좌, 우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean inRange(int y, int x) {
		return 0 <= y && y < m && 0 <= x && x < n;
	}

	static int dfs(int y, int x) {
		visited[y][x] = true;
		int cnt = 1;

		for (int dir = 0; dir < 4; dir++) {
			int nextY = y + dy[dir];
			int nextX = x + dx[dir];
			if (inRange(nextY, nextX) && !visited[nextY][nextX]) {
				cnt += dfs(nextY, nextX);
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visited = new boolean[m][n];

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					visited[i][j] = true;
				}
			}
		}

		// 분리된 각 영역의 넓이를 구한다.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					area.add(dfs(i, j));
				}
			}
		}

		// 각 영역의 넓이를 오름차순으로 정렬
		Collections.sort(area);

		// 결과 출력
		System.out.println(area.size());
		for (int i = 0; i < area.size(); i++) {
			System.out.print(area.get(i) + " ");
		}
	}
}