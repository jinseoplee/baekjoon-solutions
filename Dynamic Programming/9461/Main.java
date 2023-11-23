import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[101];
		dp[1] = dp[2] = dp[3] = 1;
		for (int i = 4; i < 101; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}
}