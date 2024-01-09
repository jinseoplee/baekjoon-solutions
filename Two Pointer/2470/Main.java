import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		// 투 포인터 알고리즘
		int left = 0;
		int right = n - 1;
		int minDiff = Integer.MAX_VALUE;
		int a = 0, b = 0; // 두 용액
		while (left < right) {
			int sum = arr[left] + arr[right];
			int diff = Math.abs(sum);
			if (diff < minDiff) {
				minDiff = diff;
				a = arr[left];
				b = arr[right];
			}
			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(a + " " + b);
	}
}