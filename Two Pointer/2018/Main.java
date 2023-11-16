import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int i = 0, j = 0, sum = 0, cnt = 0;
		while (j <= n) {
			if (sum == n) {
				cnt++;
				sum += ++j;
			} else if (sum < n) {
				sum += ++j;
			} else {
				sum -= i++;
			}
		}
		System.out.println(cnt);
	}
}