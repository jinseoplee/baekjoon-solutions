import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int k = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		int[] lanCable = new int[k];
		int cnt = 0;
		long left = 1, right = 0, mid = 0;

		for (int i = 0; i < k; i++) {
			lanCable[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, lanCable[i]);
		}

		while (left <= right) {
			mid = (left + right) / 2;
			cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += lanCable[i] / mid;
			}
			if (cnt < n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(right);
	}
}