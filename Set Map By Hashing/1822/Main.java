import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		Set<Integer> a = new TreeSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 집합 a의 개수
		int m = Integer.parseInt(st.nextToken()); // 집합 b의 개수

		// 집합 a의 원소를 입력받는다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}

		// 집합 b의 원소를 입력받는다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			// 집합 a에서 b원소를 제거한다.
			a.remove(Integer.parseInt(st.nextToken()));
		}

		result.append(a.size()).append("\n");
		for (Integer e : a) {
			result.append(e).append(" ");
		}
		System.out.println(result);
	}
}