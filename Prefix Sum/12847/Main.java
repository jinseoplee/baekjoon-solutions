import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long maxProfit;
	static long[] prefixSum; // 누적 합

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		prefixSum = new long[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken()); // 누적 합 계산
		}

		// 슬라이딩 윈도우
		for (int i = m; i <= n; i++) {
			maxProfit = Math.max(maxProfit, prefixSum[i] - prefixSum[i - m]);
		}

		System.out.println(maxProfit);
	}
}