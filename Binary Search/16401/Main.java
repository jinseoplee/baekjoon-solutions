import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int findMaxLength(int left, int right, int m, int[] arr) {
		int maxLength = 0;
		while (left <= right) {
			int mid = (left + right) / 2;

			// 조카들에게 줄 수 있는 막대 과자의 개수를 구한다.
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				cnt += (arr[i]) / mid;
			}

			if (cnt >= m) {
				maxLength = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 조카의 수
		int n = Integer.parseInt(st.nextToken()); // 과자의 수
		int max = 0; // 가장 긴 과자의 길이
		int[] arr = new int[n]; // 과자 길이를 저장하는 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		System.out.println(findMaxLength(1, max, m, arr));
	}
}