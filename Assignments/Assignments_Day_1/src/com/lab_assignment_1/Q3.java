package com.lab_assignment_1;
/*
Q3. Array Copy Method
Task

public static int[] copyOf(int[] array)
Requirements

Return a new independent array with the same values.
Do not return the same reference.
Demonstrate independence by modifying the copied array.
Corner Cases

Empty array → return new empty array
Single-element array → return new array
 */
public class Q3 {

	public static int[] copyOf(int[] array){
		int n = array.length;
		int copy[] = new int[n];
		for(int i = 0; i < n; i++) {
			copy[i] = array[i];
		}
		return copy;
	}
	public static void main(String[] args) {
		int original[] = {10, 20, 8, 2, 1};
		int copy[] = copyOf(original);
		copy[1] = 30;
		System.out.println("Original array :");
		int n = original.length;
		for(int i = 0; i < n; i++) {
			System.out.print(original[i] + " ");
		}
		System.out.println();
		System.out.println("Copied array :");
		for(int i = 0; i < n; i++) {
			System.out.print(copy[i] + " ");
		}
	}

}
