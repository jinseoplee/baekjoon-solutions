import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int n, houseCnt;
	static char[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> houseCounts = new ArrayList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

	static boolean canGo(int x, int y) {
		return inRange(x, y) && map[x][y] == '1' && !visited[x][y];
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		houseCnt++;

		for (int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			if (canGo(nextX, nextY)) {
				dfs(nextX, nextY);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (canGo(i, j)) {
					houseCnt = 0;
					dfs(i, j);
					houseCounts.add(houseCnt);
				}
			}
		}

		// 단지내 집의 수를 오름차순으로 정렬
		Collections.sort(houseCounts);

		System.out.println(houseCounts.size());
		for (int i = 0; i < houseCounts.size(); i++) {
			System.out.println(houseCounts.get(i));
		}
	}
}