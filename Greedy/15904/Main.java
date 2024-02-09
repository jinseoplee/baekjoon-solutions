import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] UCPC = new char[] { 'U', 'C', 'P', 'C' };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int idx = 0;
		for (int i = 0; i < str.length; i++) {
			if (UCPC[idx] == str[i]) idx++;
			if (idx == 4) break;
		}
		if (idx == 4) {
			System.out.println("I love UCPC");
		} else {
			System.out.println("I hate UCPC");
		}
	}
}