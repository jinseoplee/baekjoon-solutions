import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] fibo = new int[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;

		// 피보나치 수를 계산합니다.
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		// n번째 피보나치 수를 출력합니다.
		System.out.println(fibo[n]);
	}
}