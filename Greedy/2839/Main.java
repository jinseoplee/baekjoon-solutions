import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (n > 0) {
			if (n % 5 == 0) {
				cnt += n / 5;
				break;
			}
			n -= 3;
			cnt++;
		}
		System.out.println(n < 0 ? -1 : cnt);
	}
}