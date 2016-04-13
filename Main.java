/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Derek	
 * Last Name: Zhang
 * Lab Section: 1A
 * email address: derekz@uci.edu
 *
 *
 * Assignment: lab4
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int smallA[] = new int[100];
		int smallB[] = new int[100];
		//int largeA[] = new int[10000];
		//int largeB[] = new int[10000];
		//File int_file2 = new File(args[1]);
		int i = 0;
		int x = 0;
		File int_file = new File(args[0]);
		try {
			Scanner inNumbers = new Scanner(int_file);
			while(inNumbers.hasNextInt()) {
				smallA[i++] = inNumbers.nextInt();
			}
			inNumbers.close();
			//Scanner inLarge = new Scanner(int_file2);
			//while(inLarge.hasNextInt()){
			//	largeA[x++] = inLarge.nextInt();
			//}
			//inLarge.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		for(int j=0;j<smallA.length;j++){
			smallB[j] = smallA[j];
		}
		//for(int k=0;k<largeA.length;k++){
		//	largeB[10000-1-k] = largeA[k];
		//}
	
		MaxHeap smallMax = new MaxHeap(smallA);
		try{
			System.out.println("Testing maxHeapInsert when heap is not full......");
			smallMax.maxHeapInsert(21);
			System.out.println("Testing heapExtractMax when heap is not empty.....");
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			smallMax.heapExtractMax();
			System.out.println("Testing heapExtractMax on an empty heap....");
			smallMax.heapExtractMax();
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		try{
			System.out.println("Testing heapMax on an empty heap....");
			smallMax.heapMax();
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		MinHeap smallMin = new MinHeap(smallB);
		try{
			System.out.println("Testing minHeapInsert when heap is not full......");
			smallMin.minHeapInsert(2);
			System.out.println("Testing heapExtractMin when heap is not empty.....");
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			smallMin.heapExtractMin();
			System.out.println("Testing heapExtractMin on an empty heap....");
			smallMin.heapExtractMin();
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		try{
			System.out.println("Testing heapMin on an empty heap....");
			smallMin.heapMin();
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		
		/*MaxHeap largeMax  = new MaxHeap(largeA);
		try{
		System.out.println("Testing maxHeapInsert when heap is full......");
		largeMax.maxHeapInsert(21);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		MinHeap largeMin = new MinHeap(largeB);
		try{
		System.out.println("Testing minHeapInsert when heap is full......");
		largeMin.minHeapInsert(21);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		//System.out.println("Testing heapExtractMax when heap is empty.....");
		*/
		
		
	}

}
