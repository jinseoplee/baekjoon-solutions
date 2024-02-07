import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		// 나무가 다 자라는데 걸리는 시간을 오름차순으로 정렬한다.
		Arrays.sort(t);

		// 다 자라는데 걸리는 시간이 긴 나무부터 심는다.
		int day = 1;
		int elapsedTime = 0;
		for (int i = n - 1; i >= 0; i--) {
			t[i] += day++;
			elapsedTime = Math.max(elapsedTime, t[i]);
		}
		System.out.println(elapsedTime + 1);
	}
}