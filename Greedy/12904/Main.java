import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder t = new StringBuilder(br.readLine());

		while (s.length() < t.length()) {
			if (t.charAt(t.length() - 1) == 'A') {
				t.deleteCharAt(t.length() - 1);
			} else {
				t.deleteCharAt(t.length() - 1);
				t.reverse();
			}
		}

		if (s.equals(t.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}