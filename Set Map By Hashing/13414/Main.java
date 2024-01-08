import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int k = Integer.parseInt(input[0]);
		int l = Integer.parseInt(input[1]);

		Set<String> set = new LinkedHashSet<>();

		for (int i = 0; i < l; i++) {
			String id = br.readLine();
			if (set.contains(id)) {
				set.remove(id);
			}
			set.add(id);
		}

		int idx = 0;
		for (String id : set) {
			if (++idx > k) break;
			sb.append(id).append("\n");
		}
		System.out.println(sb);
	}
}