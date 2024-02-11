import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] arr = new double[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Double.valueOf(st.nextToken());
		}

		Arrays.sort(arr);

		double max = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			max += arr[i] / 2;
		}
		System.out.println(max);
	}
}