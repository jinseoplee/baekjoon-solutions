import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(br.readLine());

			int[] dp = new int[m + 1];
			dp[0] = 1;

			for (int i = 0; i < n; i++) {
				int coin = Integer.parseInt(st.nextToken());
				for (int j = coin; j <= m; j++) {
					dp[j] = dp[j] + dp[j - coin];
				}
			}

			sb.append(dp[m]).append("\n");
		}
		System.out.println(sb);
	}
}