import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;

	static int binarySearch(int target) {
		int i = 0;
		int j = n - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (arr[mid] == target) {
				return 1;
			} else if (arr[mid] < target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 이진 탐색을 위한 정렬 수행
		Arrays.sort(arr);

		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
		}
		System.out.println(sb);
	}
}