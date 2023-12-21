import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, String> map = new HashMap<>();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			map.put(site, password);
		}

		while (m-- > 0) {
			String site = br.readLine();
			answer.append(map.get(site)).append("\n");
		}
		System.out.println(answer);
	}
}