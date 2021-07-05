package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//힌트**
//100 이하의 수는 모두 한수이다!
public class boj_1065_한수 {
	public static int N;
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			int a = i / 100;
			int b = (i % 100) / 10;
			int c = (i % 10);
			if (i < 100)
				count++;
			else {
				if((c-b)==(b-a))
					count++;
			}

		}
		System.out.println(count);
	}
}
