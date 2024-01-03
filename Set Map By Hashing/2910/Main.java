import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		// 순서를 보장하는 맵
		Map<Integer, Integer> map = new LinkedHashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		// 빈도 정렬 수행
		List<Integer> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) - map.get(o1);
			}
		});

		// 결과 출력
		for (Integer key : keyList) {
			for (int i = 0; i < map.get(key); i++) {
				result.append(key).append(" ");
			}
		}
		System.out.println(result);
	}
}