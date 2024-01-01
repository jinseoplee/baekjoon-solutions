import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int maxEnergy;
	static List<Integer> list = new ArrayList<>();

	// 에너지의 최댓값을 계산한다.
	static void calcMaxEnergy(int energy) {
		if (list.size() == 2) {
			maxEnergy = Math.max(maxEnergy, energy);
			return;
		}

		for (int i = 1; i < list.size() - 1; i++) {
			int temp = list.get(i);
			int gather = list.get(i - 1) * list.get(i + 1);
			list.remove(i);
			calcMaxEnergy(energy + gather);
			list.add(i, temp);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		calcMaxEnergy(0);
		System.out.println(maxEnergy);
	}
}