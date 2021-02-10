package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ch6_성적이낮은순서로학생출력하기 {
	static class Student implements Comparable<Student>{
		String name;
		int grade;
		
		Student(String name, int grade){
			this.name = name;
			this.grade = grade;
		}
		public String getName() {
			return name;
		}
		public int getGrade() {
			return grade;
		}
		@Override
		public int compareTo(Student other) {
			// TODO Auto-generated method stub
			if(this.grade > other.grade)
				return 1;
			return -1;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(students);
		for (int j = 0; j < students.size(); j++) {
			System.out.print(students.get(j).getName()+ " ");			
		}
	}
}
