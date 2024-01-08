import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine()); // 의상의 수
			int numOfCases = 1;

			Map<String, Integer> map = new HashMap<>(); // 의상의 종류 - 개수

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken(); // 의상의 이름
				String type = st.nextToken(); // 의상의 종류
				map.put(type, map.getOrDefault(type, 0) + 1);
			}

			for (int val : map.values()) {
				numOfCases *= val + 1;
			}
			answer.append(numOfCases - 1).append("\n");
		}

		System.out.println(answer);
	}
}