
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
 * Filename : MaxHeap.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

package lab4;

public class MaxHeap {
	private int h[];
	private int currentSize; //the number of items stored in h
	public static final int CAPACITY = 100; //max size 
	public MaxHeap() { 
		//Initialize h of size CAPACITY
		this.h = new int[CAPACITY];
		this.currentSize = 0;
	}
	public MaxHeap(int[] A){
		//Initialize h of size CAPACITY
		//Copy A into h
		this.h = new int[CAPACITY];
		for(int i=0;i<A.length;i++){
			if(A[i] == 0){
				break;
			}
			else{
				this.currentSize++;
			}
		}
		this.h = A;
		buildMaxHeap();
	}
	public void buildMaxHeap(){
		for (int i = (this.currentSize/2)-1;i>=0;i--){
			trickleDown(i);
		}
		printMaxHeap();
	}
	int heapMax(){
			if(this.currentSize == 0){
				throw new IndexOutOfBoundsException("Heap is empty");
			}
			else{
				return this.h[0];
			}
	}
	void heapExtractMax(){
		int first = 0;
		int last = this.currentSize;
		int temp;
			if(this.currentSize == 0){
				throw new IndexOutOfBoundsException("Heap is empty");
			}
			temp = h[last-1];
			h[first] = temp;
			this.currentSize--;
			if(this.currentSize != 0){
				trickleDown(0);
			}
			else{
				this.currentSize = 0;
				h[0] = 0;
			}
			printMaxHeap();
	}
	void maxHeapInsert(int key){
		int size = CAPACITY;
		this.currentSize++;
			if(this.currentSize > size){
				throw new ArrayIndexOutOfBoundsException("Heap is full");
			}
			h[this.currentSize-1] = key;
			trickleUp(this.currentSize-1);
			printMaxHeap();
	}
	void trickleDown(int index){
		if(index <= 0 && index >= this.currentSize){
			throw new IndexOutOfBoundsException("Out of heap");
		}
		int parent = index;
		int left = 2*index + 1;
		int right = 2*index + 2;
		int temp;
		while(left <= this.currentSize){
			if(right >= this.currentSize){			//if  right child does not exist. 
				if(h[parent] < h[left]){
						temp = h[parent];
						h[parent] = h[left];
						h[left] = temp;
					}
				}
				else{
					if(h[left] < h[right]){
						left++;
					}
					if(h[parent] <= h[left]){
						temp = h[parent];
						h[parent] = h[left];
						h[left] = temp;
					}
				}	
				parent = left;
				left = 2*parent +1;
				right = 2*parent+2;
		}
	}
	void trickleUp(int index){
		int parent = (index-1)/2;
		int temp;
		while(index != 0 && h[index] > h[parent]){
			temp = h[parent];
			h[parent] = h[index];
			h[index] = temp;
			index = parent;
			parent = (index-1)/2;
		}
	}
	void printMaxHeap(){
		int row = 0;
		int itemsPerRow = 1;
		int j = 0; 
		while(j <= this.currentSize){           
			if(row == 0){
					System.out.println("Max heap");
					System.out.println(h[j]);
					j++;
					if(this.currentSize == 0){
						break;
					}
			}
			if(j == this.currentSize){
				break;
			}
			else{
				for(int i=0; i<itemsPerRow*2;i++){
					if(j == this.currentSize){
						break;
					}
					else if(h[j] == 0){
						j++;
					}
					else{
						System.out.print(h[j]);
						System.out.print(" ");
						j++;
					}
				}
				System.out.println();
				row++;
				itemsPerRow *= 2;
			}		
		}
	}
	
}

