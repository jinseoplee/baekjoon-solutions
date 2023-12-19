import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] honey;
	static int[] sum; // 누적 합

	// 최대로 얻을 수 있는 꿀의 양을 반환한다.
	static int getMaxHoney() {
		int maxHoney = 0;

		for (int i = 2; i < n; i++) {
			// 벌 - 벌 - 벌통
			maxHoney = Math.max(maxHoney, (sum[n] - honey[1] - honey[i]) + (sum[n] - sum[i]));
			// 벌통 - 벌 - 벌
			maxHoney = Math.max(maxHoney, (sum[n] - honey[n] - honey[i]) + (sum[i] - honey[i]));
			// 벌 - 벌통 - 벌
			maxHoney = Math.max(maxHoney, (sum[i] - honey[1]) + (sum[n] - sum[i - 1] - honey[n]));
		}

		return maxHoney;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		honey = new int[n + 1];
		sum = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + honey[i];
		}

		System.out.println(getMaxHoney());
	}
}