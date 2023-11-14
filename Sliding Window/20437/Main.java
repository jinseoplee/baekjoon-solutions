import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static final int MAX_VALUE = 10001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			// 입력 처리
			char[] w = br.readLine().toCharArray();
			int k = Integer.parseInt(br.readLine());

			ArrayList<Integer>[] list = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < w.length; i++) {
				list[w[i] - 'a'].add(i);
			}

			int min = MAX_VALUE;
			int max = 0;
			for (int i = 0; i < 26; i++) {
				if (list[i].size() >= k) {
					for (int j = k - 1; j < list[i].size(); j++) {
						int length = list[i].get(j) - list[i].get(j - k + 1) + 1;
						min = Math.min(min, length);
						max = Math.max(max, length);
					}
				}
			}

			if (min == MAX_VALUE) {
				sb.append("-1").append("\n");
			} else {
				sb.append(min).append(" ").append(max).append("\n");
			}
		}

		// 결과 출력
		System.out.println(sb);
	}
}