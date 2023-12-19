import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long answer;
	static int[] arr;
	static long[] prefixSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[n + 1];
		prefixSum = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		for (int i = 1; i < n; i++) {
			answer += arr[i] * (prefixSum[n] - prefixSum[i]);
		}

		System.out.println(answer);
	}
}