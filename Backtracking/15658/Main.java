import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr;

	static void findMaxAndMinValue(int cnt, int value, int addCnt, int subCnt, int mulCnt, int divCnt) {
		if (cnt == n - 1) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}

		if (addCnt != 0) {
			findMaxAndMinValue(cnt + 1, value + arr[cnt + 1], addCnt - 1, subCnt, mulCnt, divCnt);
		}

		if (subCnt != 0) {
			findMaxAndMinValue(cnt + 1, value - arr[cnt + 1], addCnt, subCnt - 1, mulCnt, divCnt);
		}

		if (mulCnt != 0) {
			findMaxAndMinValue(cnt + 1, value * arr[cnt + 1], addCnt, subCnt, mulCnt - 1, divCnt);
		}

		if (divCnt != 0) {
			findMaxAndMinValue(cnt + 1, value / arr[cnt + 1], addCnt, subCnt, mulCnt, divCnt - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int addCnt = Integer.parseInt(st.nextToken());
		int subCnt = Integer.parseInt(st.nextToken());
		int mulCnt = Integer.parseInt(st.nextToken());
		int divCnt = Integer.parseInt(st.nextToken());

		findMaxAndMinValue(0, arr[0], addCnt, subCnt, mulCnt, divCnt);

		System.out.println(max);
		System.out.println(min);
	}
}