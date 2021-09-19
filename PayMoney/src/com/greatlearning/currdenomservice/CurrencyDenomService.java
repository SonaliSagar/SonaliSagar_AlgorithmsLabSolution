package com.greatlearning.currdenomservice;

//service class contains sorting and notesCount business logic
public class CurrencyDenomService {

	// main method to sort the currency notes array in descending order
	public void sortAmount(int[] currArray, int left, int right) {
		if(left < right) {
			
			//find middle point of the array
			int mid = (left + right) / 2;
			
			//sort left and right halves
			sortAmount(currArray, left, mid);
			sortAmount(currArray, mid+1, right);
			
			//merge both the sorted halves
			mergeAmount(currArray, left, mid, right);
		}
	}// end of sorting currency notes 

    //to merge both the sorted halves
	private void mergeAmount(int[] currArray, int left, int mid, int right) {
		
		int n1 = mid  - left + 1;
		int n2 = right - mid;
		
		int leftArr[] = new int[n1];
		int rightArr[] = new int[n2];
		
		for(int i = 0; i < n1; i++) {
			leftArr[i] = currArray[left + i];
		}
		
		for(int j = 0; j < n2; j++) {
			rightArr[j] = currArray[mid + 1 + j];
		}
		
		//merge temporary arrays
		int i, j, k ;
		
		//initial indexes of two sub-arrays
		i = 0;
		j = 0;
		
		//initial index of merged sub-array
		k = left;
		
		while(i < n1 && j < n2) {
			if(leftArr[i] >= rightArr[j]) {
				currArray[k] = leftArr[i];
				i++;
			}else {
				currArray[k] = rightArr[j];
				j++;
			}
			k++;	
		}
		
		//copy remaining elements of left array
		while(i < n1) {
			currArray[k] = leftArr[i];
			i++;
			k++;
		}
		
		//copy remaining elements of right array
		while(j < n2) {
			currArray[k] = rightArr[j];
			j++;
			k++;
		}
	}//end of merging sorted halves

	//To find out the min. notes count for current amount 
	public void notesCount(int[] currArray, int amount) {
		// to keep a track of the counts of the notes
		int[] notesCounter = new int[currArray.length];
		
		//try catch block to handle the exceptions as like 0 notes of denomination 
		try {
			//check till last element of currArray 
			for(int i = 0; i < currArray.length; i++) {
				//to find out the count of each currency notes and 
				if(amount >= currArray[i]) {
					notesCounter[i] = amount / currArray[i];
					amount = amount - notesCounter[i] * currArray[i];
				}
			}
			
			//amount can't be paid as amount is greater than zero and can't be paid with available denominations
			if(amount > 0) {
				System.out.println(" Exact amount cannot be given with highest denomination!!!");
			}
			else {
				System.out.println("Your payment approach in order to give min no of notes will be : ");
				for(int i = 0; i < currArray.length; i++) {
					if(notesCounter[i] != 0) {
						System.out.println(currArray[i] + " : " + notesCounter[i]);
					}
				}
			}
		}catch(ArithmeticException e) {
			System.out.println(e + " notes of denomination 0 is invalid!!! ");
		}
	
	}// end of counts of notes 
	
}

