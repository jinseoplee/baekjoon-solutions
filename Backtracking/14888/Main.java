import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주어진 n-1개의 연산자로 만들 수 있는 모든 식을 구하기 위해 백트래킹 알고리즘 사용
 */
public class Main {
	static int n;
	static int maxValue = Integer.MIN_VALUE;
	static int minValue = Integer.MAX_VALUE;
	static int[] nums;

	static void calcMaxAndMinValue(int cnt, int value, int addCnt, int subCnt, int mulCnt, int divCnt) {
		// n-1개의 연사자를 사용한 경우
		if (cnt == n - 1) {
			maxValue = Math.max(maxValue, value);
			minValue = Math.min(minValue, value);
			return;
		}

		if (addCnt > 0) {
			calcMaxAndMinValue(cnt + 1, value + nums[cnt + 1], addCnt - 1, subCnt, mulCnt, divCnt);
		}

		if (subCnt > 0) {
			calcMaxAndMinValue(cnt + 1, value - nums[cnt + 1], addCnt, subCnt - 1, mulCnt, divCnt);
		}

		if (mulCnt > 0) {
			calcMaxAndMinValue(cnt + 1, value * nums[cnt + 1], addCnt, subCnt, mulCnt - 1, divCnt);
		}

		if (divCnt > 0) {
			calcMaxAndMinValue(cnt + 1, value / nums[cnt + 1], addCnt, subCnt, mulCnt, divCnt - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int addCnt = Integer.parseInt(st.nextToken());
		int subCnt = Integer.parseInt(st.nextToken());
		int mulCnt = Integer.parseInt(st.nextToken());
		int divCnt = Integer.parseInt(st.nextToken());

		// 최댓값과 최솟값을 구한다.
		calcMaxAndMinValue(0, nums[0], addCnt, subCnt, mulCnt, divCnt);

		System.out.println(maxValue + "\n" + minValue);
	}
}