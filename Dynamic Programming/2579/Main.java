import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[301];
		for (int i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[301];
		dp[1] = score[1];
		dp[2] = score[1] + score[2];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
		}
		System.out.println(dp[n]);
	}
}