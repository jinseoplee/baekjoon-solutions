import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int n, k;
	static int[] card;
	static boolean[] selected;
	static Set<String> set = new HashSet<>();

	static void select(int cnt, String num) {
		if (cnt == k) {
			set.add(num);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!selected[i]) {
				selected[i] = true;
				select(cnt + 1, num + card[i]);
				selected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		card = new int[n];
		selected = new boolean[n];

		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}

		select(0, "");

		System.out.println(set.size());
	}
}