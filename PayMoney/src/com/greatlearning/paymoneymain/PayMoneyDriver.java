package com.greatlearning.paymoneymain;
import java.util.Scanner;

import com.greatlearning.paymoneyservice.PayMoneyService;

public class PayMoneyDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int transactionSize = 0;
		//1. Accept total count of transactions.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of transaction array ");
		transactionSize = sc.nextInt();
		
		int transactionArray[] = new int[transactionSize];
		
		// accept transactions
		System.out.println("Enter the values of array ");
		for(int i = 0; i < transactionSize; i++) {
			transactionArray[i] = sc.nextInt();
		}
		
		//Accept count of targets
		int totalTarget = 0;
		System.out.println("Enter the total no of targets that needs to be achieved");
		totalTarget = sc.nextInt();
		
		//Check target is achieved or not?
		PayMoneyService service = new PayMoneyService();
		service.checkTarget(transactionArray, totalTarget);
		
		sc.close();//close scanner  
	}

}
