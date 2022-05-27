package greedyAlgorithm;
import java.util.*;

public class boj4796 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		while(true) {
			int result = 0;
			int L = sc.nextInt();
			int P = sc.nextInt();
			int V = sc.nextInt();
			cnt++;
			
			if(L==0 && P==0 && V==0) break;
			result += (V / P) * L;
			if((V % P) > L) result += L;
			else result += (V % P);
			
			System.out.println("Case "+ cnt + ": " + result);
		}
	}
}

