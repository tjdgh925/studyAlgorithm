package dynamicProgramming;

public class ch8_피보나치수열 {
	static int Fibonacci(int x) {
		if(x==1 || x==2) {
			return 1;
		}else {
			return Fibonacci(x-1) + Fibonacci(x-2);
		}
	}
	public static void main(String[] args) {
		System.out.println(Fibonacci(4));
	}
}
