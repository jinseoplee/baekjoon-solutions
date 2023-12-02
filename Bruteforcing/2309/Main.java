import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] height = new int[9];
	static int[] selected = new int[9];
	static int[] answer = new int[7];

	static void findSevenDwarf(int start, int cnt, int sum) {
		// 일곱 난쟁이를 선택한 경우
		if (cnt == 7) {
			// 일곱 난쟁이의 키의 합이 100인 경우
			if (sum == 100) {
				System.arraycopy(selected, 0, answer, 0, 7);
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			selected[cnt] = height[i];
			findSevenDwarf(i + 1, cnt + 1, sum + height[i]);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 아홉 난쟁이의 키를 입력받는다.
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}

		// 오름차순으로 정렬 수행
		Arrays.sort(height);

		findSevenDwarf(0, 0, 0);

		// 정답 출력
		for (int h : answer) {
			System.out.println(h);
		}
	}
}