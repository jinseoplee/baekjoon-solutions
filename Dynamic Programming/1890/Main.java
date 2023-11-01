import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[n][n];
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 경로가 있고 점프 숫자가 있는 경우
				if (dp[i][j] > 0 && arr[i][j] > 0) {
					int jump = arr[i][j];
					// 오른쪽으로 점프
					if (i + jump < n) {
						dp[i + jump][j] += dp[i][j];
					}
					// 아래로 점프
					if (j + jump < n) {
						dp[i][j + jump] += dp[i][j];
					}
				}
			}
		}

		System.out.println(dp[n - 1][n - 1]);
	}
}