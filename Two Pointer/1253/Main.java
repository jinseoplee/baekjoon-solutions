import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int cnt = 0; // 좋은 수 개수

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int k = 0; k < n; k++) {
			int find = arr[k];
			int startIdx = 0;
			int endIdx = n - 1;

			// 투 포인터 알고리즘
			while (startIdx < endIdx) {
				int sum = arr[startIdx] + arr[endIdx];
				if (sum == find) {
					// 서로 다른 두 수인지 체크
					if (startIdx != k && endIdx != k) {
						cnt++;
						break;
					} else if (startIdx == k) {
						startIdx++;
					} else if (endIdx == k) {
						endIdx--;
					}
				} else if (sum < find) {
					startIdx++;
				} else {
					endIdx--;
				}
			}
		}
		System.out.println(cnt);
	}
}