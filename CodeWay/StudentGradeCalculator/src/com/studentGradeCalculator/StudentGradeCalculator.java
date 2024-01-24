package com.studentGradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter number of subjects ?");
		int subjects=scan.nextInt();
		int [] eachSubject=new int[subjects];
		int totalMarks=0;
		for(int i=0;i<=subjects-1;i++) {
			System.out.println("Marks in subject "+(i+1));
			eachSubject[i]=scan.nextInt();
			if(eachSubject[i]<0 || eachSubject[i]>100) {
				System.out.println("Inavlid marks, please enter the marks in between 1 to 100");
				i--;
			}
			else {
				
				totalMarks=totalMarks+eachSubject[i];
			}
		}
		System.out.println(totalMarks);
		double avgPercentage=totalMarks/subjects;
		System.out.println("Result : ");
		System.out.println("Total marks "+totalMarks);
		System.out.println("Average percentage "+avgPercentage+" %");
		System.out.println("Corresponding grade "+calculateGrade(avgPercentage));
		
		
	}
	public static char calculateGrade(double avgPercentage) {
		if(avgPercentage>=90)
			return 'A';
		else if(avgPercentage>=80&& avgPercentage<90)
			return 'B';
		else if(avgPercentage>=70 && avgPercentage<80)
			return 'C';
		else if(avgPercentage>=60&& avgPercentage<70)
			return 'D';
		else if(avgPercentage>=50&& avgPercentage<60)
			return 'E';
		else if(avgPercentage>=40&& avgPercentage<50)
			return 'F';
		else {
			return 'G';
		}
	}

}
