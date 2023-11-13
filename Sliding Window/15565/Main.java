import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> lions = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if ("1".equals(st.nextToken())) {
				lions.add(i);
			}
		}

		if (lions.size() < k) {
			System.out.println("-1");
			return;
		}

		int minSetSize = Integer.MAX_VALUE;
		for (int i = k - 1; i < lions.size(); i++) {
			minSetSize = Math.min(minSetSize, lions.get(i) - lions.get(i - k + 1) + 1);
		}
		System.out.println(minSetSize);
	}
}