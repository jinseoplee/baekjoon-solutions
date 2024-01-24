import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX_SIZE = 116;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// dp 테이블 생성 및 초기화
		long[] dp = new long[MAX_SIZE + 1];
		dp[1] = dp[2] = dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}
		System.out.println(dp[n]);
	}
}