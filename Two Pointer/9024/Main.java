import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			// 투 포인터 알고리즘
			int startIdx = 0;
			int endIdx = n - 1;
			int minDiff = Integer.MAX_VALUE;
			int cnt = 0;
			while (startIdx < endIdx) {
				int sum = arr[startIdx] + arr[endIdx];
				int diff = Math.abs(k - sum);
				if (diff < minDiff) {
					minDiff = diff;
					cnt = 1;
				} else if (diff == minDiff) {
					cnt++;
				}

				if (sum == k) {
					startIdx++;
					endIdx--;
				} else if (sum < k) {
					startIdx++;
				} else {
					endIdx--;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}