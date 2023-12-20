import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int STUDENT_COUNT = 20;

	// 학생들이 뒤로 물러난 걸음 수를 구한다.
	static int getStepCount(int[] height) {
		int stepCount = 0;

		for (int i = 0; i < STUDENT_COUNT; i++) {
			for (int j = 0; j < i; j++) {
				if (height[j] > height[i]) stepCount++;
			}
		}

		return stepCount;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int testCaseNum = Integer.parseInt(st.nextToken());
			int[] height = new int[STUDENT_COUNT];
			for (int i = 0; i < STUDENT_COUNT; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			answer.append(testCaseNum).append(" ").append(getStepCount(height)).append("\n");
		}

		System.out.println(answer);
	}
}