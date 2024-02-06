import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_SIZE = 10_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		BigInteger[] dp = new BigInteger[MAX_SIZE + 1];
		dp[1] = dp[2] = BigInteger.valueOf(1);
		for (int i = 3; i <= MAX_SIZE; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}

		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			answer.append("Case #").append(testCase).append(": ");
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			answer.append(dp[p].remainder(BigInteger.valueOf(q))).append("\n");
		}

		System.out.println(answer);
	}
}