import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int maxProfit = -1000;
		int[][] sum = new int[n + 1][n + 1]; // 누적 합

		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= n; c++) {
				int profit = Integer.parseInt(st.nextToken());
				sum[r][c] = sum[r][c - 1] + sum[r - 1][c] - sum[r - 1][c - 1] + profit;
				maxProfit = Math.max(maxProfit, profit);
			}
		}

		// 누적 합을 이용하여 최대 총이익을 구한다.
		for (int k = 2; k <= n; k++) {
			for (int r = k; r <= n; r++) {
				for (int c = k; c <= n; c++) {
					maxProfit = Math.max(maxProfit, sum[r][c] - sum[r][c - k] - sum[r - k][c] + sum[r - k][c - k]);
				}
			}
		}

		System.out.println(maxProfit);
	}
}