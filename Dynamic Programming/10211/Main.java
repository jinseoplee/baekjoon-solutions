import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// dp 테이블 생성
			int[] dp = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(dp[i - 1] + num, num);
			}

			int max = -1001;
			for (int i = 1; i <= n; i++) {
				max = Math.max(max, dp[i]);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}