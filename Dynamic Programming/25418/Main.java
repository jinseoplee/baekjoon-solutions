import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp = new int[1_000_001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp[a] = 0;
		for (int i = a + 1; i <= k; i++) {
			// 1을 더한 경우
			dp[i] = dp[i - 1] + 1;

			// 2를 곱한 경우
			if (i % 2 == 0 && i / 2 >= a) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}

		System.out.println(dp[k]);
	}
}