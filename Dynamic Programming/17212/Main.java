import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX_SIZE = 100_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[MAX_SIZE + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;
		for (int i = 8; i <= MAX_SIZE; i++) {
			dp[i] = dp[i - 1] + 1;
			dp[i] = Math.min(dp[i], dp[i - 2] + 1);
			dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			dp[i] = Math.min(dp[i], dp[i - 7] + 1);
		}
		System.out.println(dp[n]);
	}
}