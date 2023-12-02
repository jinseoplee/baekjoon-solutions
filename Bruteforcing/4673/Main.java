import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX_SIZE = 10001;
	static boolean[] selfNumber = new boolean[MAX_SIZE];

	// 셀프 넘버를 찾는다.
	static void findSelfNumber() {
		for (int i = 1; i < MAX_SIZE; i++) {
			int y = d(i);
			if (y < MAX_SIZE) {
				selfNumber[y] = false;
			}
		}
	}

	// d(n): n과 n의 각 자릿수를 더하는 함수
	static int d(int n) {
		int y = n;
		while (n != 0) {
			y += n % 10;
			n /= 10;
		}
		return y;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		Arrays.fill(selfNumber, true);

		findSelfNumber();

		// 셀프 넘버를 출력한다.
		for (int i = 1; i < MAX_SIZE; i++) {
			if (selfNumber[i]) {
				answer.append(i).append("\n");
			}
		}
		System.out.println(answer);
	}
}