import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (input.equals("ENTER")) {
				cnt += set.size();
				set.clear();
				continue;
			}
			set.add(input);
		}
		cnt += set.size();

		System.out.println(cnt);
	}
}