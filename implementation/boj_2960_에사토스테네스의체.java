package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class boj_2960_에사토스테네스의체 {
	static boolean check[];
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		count = 0;
		check = new boolean[N + 1];
		
		int answer = solve(check, K);
		System.out.println(answer);
	}

	private static int solve(boolean[] check, int k) {
		List<Integer> answer = new ArrayList<>();
        int cnt =0;
        for(int i=2; i<check.length; i++){
            if(check[i] == false) {
                answer.add(i);
            }
            for(int j=2*i; j<check.length; j+=i){ 
            	if(check[j] == false)
                    answer.add(j);
                check[j] = true;
            }
        }
        return answer.get(k-1);
    }
}

