import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int maxLength = 1, length = 1;
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			if (arr[i] >= arr[i - 1]) {
				length++;
			} else {
				length = 1;
			}
			maxLength = Math.max(maxLength, length);
		}

		length = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i] <= arr[i - 1]) {
				length++;
			} else {
				length = 1;
			}
			maxLength = Math.max(maxLength, length);
		}

		System.out.println(maxLength);
	}
}