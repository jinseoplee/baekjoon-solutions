import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Boolean> map = new HashMap<>();
		List<String> list = new ArrayList<>();

		// 듣도 못한 사람을 입력받는다.
		while (n-- > 0) {
			String name = br.readLine();
			map.put(name, true);
		}

		// 보도 못한 사람을 입력받는다.
		while (m-- > 0) {
			String name = br.readLine();
			// 듣도 못한 사람인 경우 듣보잡 명단에 추가한다.
			if (map.containsKey(name)) {
				list.add(name);
			}
		}

		// 듣보잡의 수와 그 명단을 사전 순으로 출력한다.
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (String name : list) {
			sb.append(name).append("\n");
		}
		System.out.println(sb);
	}
}