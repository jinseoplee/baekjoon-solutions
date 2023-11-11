import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		// dp 테이블 초기화
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 2; i <= n; i++) {
				dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
				dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
			}
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
		System.out.println(sb);
	}
}