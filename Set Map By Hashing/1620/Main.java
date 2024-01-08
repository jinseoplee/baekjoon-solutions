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

		Map<String, Integer> pokemonMap = new HashMap<>(); // 이름 - 번호
		String[] pokemonArr = new String[n + 1]; // 번호 - 이름

		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			pokemonMap.put(name, i);
			pokemonArr[i] = name;
		}

		for (int i = 1; i <= m; i++) {
			String problem = br.readLine();
			if (problem.charAt(0) < 'A') {
				answer.append(pokemonArr[Integer.parseInt(problem)]);
			} else {
				answer.append(pokemonMap.get(problem));
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
}