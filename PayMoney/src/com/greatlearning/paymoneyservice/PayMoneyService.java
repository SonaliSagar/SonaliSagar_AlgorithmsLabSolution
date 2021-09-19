package com.greatlearning.paymoneyservice;
import java.util.Scanner;

//PayMoneyService class to implement business logic
public class PayMoneyService {

	//Method to check target is achievable or not?
	public void checkTarget(int[] transactionArray, int totalTarget) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		int flag = 0;
		long target;
		
		while(totalTarget-- != 0) {
			System.out.println("\n Enter the value of target ");
		    target = sn.nextInt();

			long targetSum = 0;
			
			for(int i = 0; i < transactionArray.length; i++) {
				targetSum += transactionArray[i];
				
				if(targetSum >= target) {
					System.out.println("\n Target achieved after " + (i+1) + " transactions");
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				System.out.println("Given target is not achieved ");
			}
				
		}
		System.out.println("\n All targets has been done!!!");
		sn.close(); //close scanner 
	}//method completed
}
