package com.greatlearning.currdenom;

import java.util.Scanner;

import com.greatlearning.currdenomservice.CurrencyDenomService;

public class CurrDenomDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			int size = 0; 
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the size of currency denominations ");
			size = sc.nextInt();
			
			int currArray[] = new int[size];
			System.out.println("Enter the currency denominations value");
			for(int i = 0; i < size; i++) {
				currArray[i] = sc.nextInt();
			}	
			
			int amount = 0;
			CurrencyDenomService service = new CurrencyDenomService();
			System.out.println("Enter the amount you want to pay ");
			amount = sc.nextInt();
			
			//sort the notes in descending order as we have to give min notes count
			service.sortAmount(currArray, 0, currArray.length-1);
			
			//find the min counts of notes to pay amount
			service.notesCount(currArray, amount);
			
			sc.close(); //close scanner 
			
	}//psvm
}
