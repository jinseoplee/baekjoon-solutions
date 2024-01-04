import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 동, 남, 서, 북
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static void rotate(int n, int m, int rotateCnt, int[][] arr) {
		int cnt = Math.min(n, m) / 2; // 회전시킬 그룹의 개수

		for (int k = 0; k < rotateCnt; k++) {
			for (int i = 0; i < cnt; i++) {
				int r = i;
				int c = i;
				int dir = 0;
				int temp = arr[r][c];

				while (dir < 4) {
					int nextR = r + dr[dir];
					int nextC = c + dc[dir];

					// 범위를 벗어나는 경우 방향을 바꾼다.
					if (nextR < i || nextR == n - i || nextC < i || nextC == m - i) {
						dir++;
						continue;
					}

					arr[r][c] = arr[nextR][nextC];
					r = nextR;
					c = nextC;
				}

				arr[i + 1][i] = temp;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 가로
		int m = Integer.parseInt(st.nextToken()); // 세로
		int r = Integer.parseInt(st.nextToken()); // 회전 수

		// 배열 초기화
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotate(n, m, r, arr);

		// 결과 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}