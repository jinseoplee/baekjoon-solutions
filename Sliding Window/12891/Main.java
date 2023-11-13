import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int s, p, ans;
	static int cntA, cntC, cntG, cntT;
	static int minA, minC, minG, minT;
	static char[] dna;

	static void add(char c) {
		switch (c) {
		case 'A':
			cntA++;
			break;
		case 'C':
			cntC++;
			break;
		case 'G':
			cntG++;
			break;
		case 'T':
			cntT++;
			break;
		}
	}

	static void remove(char c) {
		switch (c) {
		case 'A':
			cntA--;
			break;
		case 'C':
			cntC--;
			break;
		case 'G':
			cntG--;
			break;
		case 'T':
			cntT--;
			break;
		}
	}

	static void isPossible() {
		if (cntA >= minA && cntC >= minC && cntG >= minG && cntT >= minT) {
			ans++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		minA = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());

		for (int i = 0; i < p; i++) {
			add(dna[i]);
		}

		isPossible();

		for (int i = p; i < s; i++) {
			add(dna[i]);
			remove(dna[i - p]);
			isPossible();
		}
		System.out.println(ans);
	}
}