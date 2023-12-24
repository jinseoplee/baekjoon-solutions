import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder LIS = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();
	static int n;
	static int[] arr, dp;

	// LIS의 길이를 구한다.
	static int findLISLength() {
		int LISLength = 0;
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			LISLength = Math.max(LISLength, dp[i]);
		}
		return LISLength;
	}

	// LIS를 구한다.
	static void findLIS(int LISLength) {
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] == LISLength) {
				stack.push(arr[i]);
				LISLength--;
			}
		}

		while (!stack.isEmpty()) {
			LIS.append(stack.pop()).append(" ");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		dp = new int[n];

		// 수열을 입력받는다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int LISLength = findLISLength();
		findLIS(LISLength);

		System.out.println(LISLength);
		System.out.println(LIS);
	}
}