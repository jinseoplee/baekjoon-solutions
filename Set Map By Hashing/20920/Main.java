import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 단어의 개수
		int m = Integer.parseInt(input[1]); // 단어의 길이 기준

		Map<String, Integer> map = new HashMap<>();

		// 자주 나오는 단어를 계산한다.
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			if (word.length() >= m) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}

		// 정렬 수행
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 자주 나오는 단어를 앞에 배치한다.
				if (map.get(o1) != map.get(o2)) {
					return map.get(o2) - map.get(o1);
				}
				// 단어의 길이가 길수록 앞에 배치한다.
				else if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				// 알파벳 사전 순으로 정렬한다.
				return o1.compareTo(o2);
			}
		});

		// 결과 출력
		for (int i = 0; i < list.size(); i++) {
			result.append(list.get(i)).append("\n");
		}
		System.out.println(result);
	}
}