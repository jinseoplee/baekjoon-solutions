import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int order = 1;
		int[] tip = new int[n];
		long maxTip = 0;

		for (int i = 0; i < n; i++) {
			tip[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(tip);

		for (int i = n - 1; i >= 0; i--) {
			int give = tip[i] - (order - 1);
			if (give > 0) maxTip += give;
			order++;
		}

		System.out.println(maxTip);
	}
}