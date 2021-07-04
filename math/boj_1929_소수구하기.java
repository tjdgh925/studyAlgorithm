package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//에라토스테네스의 체를 활용한 문
public class boj_1929_소수구하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean check[] = new boolean[1000001];
		check[1] =  true;
		for (int i = 2; i <= b; i++) {
			for (int j = 2; i*j <= b; j++) {
				if(!check[i*j]) {
					check[i*j] = true;
				}
			}
		}
		for (int i = a; i <= b; i++) {
			if(!check[i]) 
				System.out.println(i);
		}
	}
}
