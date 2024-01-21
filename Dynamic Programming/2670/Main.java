import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double max = 0.0;
		double[] dp = new double[n];
		dp[0] = Double.valueOf(br.readLine());

		for (int i = 1; i < n; i++) {
			double num = Double.valueOf(br.readLine());
			dp[i] = dp[i - 1] * num > num ? dp[i - 1] * num : num;
			max = Math.max(max, dp[i]);
		}
		System.out.println(String.format("%.3f", max));
	}
}