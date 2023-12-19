import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m, n, k;

	// 누적 합
	// 0: 정글, 1: 바다, 2: 얼음
	static int[][][] sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		sum = new int[3][m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			String line = br.readLine();
			for (int j = 1; j <= n; j++) {
				// 정글, 바다, 얼음의 누적 합을 구한다.
				for (int k = 0; k < 3; k++) {
					sum[k][i][j] = sum[k][i][j - 1] + sum[k][i - 1][j] - sum[k][i - 1][j - 1];
				}

				char c = line.charAt(j - 1);
				if (c == 'J') {
					sum[0][i][j]++;
				} else if (c == 'O') {
					sum[1][i][j]++;
				} else {
					sum[2][i][j]++;
				}
			}
		}

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			// 범위 내 정글, 바다, 얼음의 수를 구한다.
			int jungle = sum[0][c][d] - sum[0][c][b - 1] - sum[0][a - 1][d] + sum[0][a - 1][b - 1];
			int ocean = sum[1][c][d] - sum[1][c][b - 1] - sum[1][a - 1][d] + sum[1][a - 1][b - 1];
			int ice = sum[2][c][d] - sum[2][c][b - 1] - sum[2][a - 1][d] + sum[2][a - 1][b - 1];
			answer.append(jungle + " " + ocean + " " + ice).append("\n");
		}

		System.out.println(answer);
	}
}