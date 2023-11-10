import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, maxSafeZone;
	static int[][] map, spreadMap;
	static ArrayList<Virus> viruses = new ArrayList<>();

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Virus {
		int r, c;

		Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// step 3. 안전 영역을 구한다.
	static int getSafeZone() {
		int safeZone = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (spreadMap[i][j] == 0) {
					safeZone++;
				}
			}
		}
		return safeZone;
	}

	// step 2. 바이러스가 퍼진다.
	static void spread(int r, int c) {
		for (int dir = 0; dir < 4; dir++) {
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			if (inRange(nextR, nextC) && spreadMap[nextR][nextC] == 0) {
				spreadMap[nextR][nextC] = 2;
				spread(nextR, nextC);
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	// step 1. 3개의 벽을 세운다.
	static void setWall(int start, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < n; i++) {
				System.arraycopy(map[i], 0, spreadMap[i], 0, m);
			}

			for (Virus v : viruses) {
				spread(v.r, v.c);
			}

			// 안전 영역의 최대 크기를 구한다.
			maxSafeZone = Math.max(maxSafeZone, getSafeZone());
			return;
		}

		for (int i = start; i < n * m; i++) {
			int r = i / m;
			int c = i % m;
			if (map[r][c] == 0) {
				map[r][c] = 1;
				setWall(i + 1, cnt + 1);
				map[r][c] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		spreadMap = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					viruses.add(new Virus(i, j));
				}
			}
		}

		setWall(0, 0);
		System.out.println(maxSafeZone);
	}
}