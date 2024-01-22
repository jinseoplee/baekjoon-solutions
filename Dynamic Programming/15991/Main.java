import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX_SIZE = 100000;
	static final int MOD = 1_000_000_009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// dp 테이블 생성 및 초기화
		long[] dp = new long[MAX_SIZE + 1];
		dp[0] = dp[1] = 1;
		dp[2] = dp[3] = 2;
		dp[4] = dp[5] = 3;
		for (int i = 6; i <= MAX_SIZE; i++) {
			dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % MOD;
		}

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}
}