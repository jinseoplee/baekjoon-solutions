import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 현재 회사에 있는 직원들의 이름을 저장하는 TreeSet
		Set<String> employees = new TreeSet<>(Collections.reverseOrder());

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String record = st.nextToken();

			if (record.equals("enter")) {
				employees.add(name);
			} else {
				employees.remove(name);
			}
		}

		for (String e : employees) {
			sb.append(e).append("\n");
		}
		System.out.println(sb);
	}
}