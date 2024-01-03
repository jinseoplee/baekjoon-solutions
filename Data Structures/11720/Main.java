import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 숫자의 개수
		String strNum = br.readLine();
		int sum = 0;
		for (int i = 0; i < strNum.length(); i++) {
			sum += strNum.charAt(i) - '0'; // 문자열 숫자 -> 정수형으로 변환
		}
		System.out.println(sum);
	}
}