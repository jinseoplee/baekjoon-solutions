import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[][] dp = new int[2][k + 1];
		dp[0][0] = 1;
		dp[1][1] = 1;
		for (int i = 2; i <= k; i++) {
			dp[0][i] = dp[1][i - 1];
			dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
		}
		System.out.println(dp[0][k] + " " + dp[1][k]);
	}
}