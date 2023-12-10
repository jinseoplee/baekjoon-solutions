import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String strNum = br.readLine();

		// 문자열 숫자를 정수 배열로 변환한다.
		int[] arr = new int[strNum.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = strNum.charAt(i) - '0';
		}

		// 선택 정렬(내림차순)
		for (int i = 0; i < arr.length - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[maxIdx] < arr[j]) {
					maxIdx = j;
				}
			}
			// swap
			int temp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = temp;
		}

		// 내림차순으로 정렬한 수를 출력한다.
		for (int i = 0; i < arr.length; i++) {
			answer.append(arr[i]);
		}
		System.out.println(answer);
	}
}