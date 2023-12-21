import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX_VALUE = 100000;
	static int[] dp = new int[MAX_VALUE + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp[1] = MAX_VALUE;
		dp[2] = 1;
		dp[3] = MAX_VALUE;
		dp[4] = 2;
		dp[5] = 1;
		for (int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
		}
		System.out.println(dp[n] == MAX_VALUE ? -1 : dp[n]);
	}
}