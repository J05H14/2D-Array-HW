package homework;

import java.util.Random;
import java.util.Scanner;

/*
 * Joshua Lazaro
 * 
 * 2D Practice
 */

public class HW08P01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[][] array;
		int row, col;
		Random r = new Random();

		System.out.print("How Many Rows: ");
		row = input.nextInt();
		System.out.print("How Many Columns: ");
		col = input.nextInt();
		System.out.println();

		array = new int[row][col];

		array = getArr(row, col);

		showTable(array);

		dispAvg(array);

		rowAvg(array);

		colAvg(array);

		majMinAvg(array);
		
		System.out.println(r.nextDouble() + "");
	}
	//fills array
	public static int[][] getArr(int row, int col){
		int[][] arr = new int[row][col];
		Random rand = new Random();

		for(row = 0; row < arr.length; row++){
			for(col = 0; col < arr[row].length; col++){
				arr[row][col] = rand.nextInt(10);
			}
		}
		return arr;
	}
	//prints array
	public static void showTable(int[][] arr){
		System.out.println("Table:");
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	//show array average
	public static void dispAvg(int[][] arr){
		int sum = 0, count = 0;
		double average;

		for(int r = 0; r < arr.length; r++){
			for(int c = 0; c < arr[r].length; c++, count++){
				sum += arr[r][c];
			}
		}
		average = (double) sum / count;
		System.out.println("The Average is: " + average);
		System.out.println();
	}
	//shows row average
	public static void rowAvg(int[][] arr){
		int sum, count;
		double avg;

		for(int r = 0; r < arr.length; r++){
			sum = 0;
			count = 0;
			for(int c = 0; c < arr[r].length; c++,count ++){
				sum += arr[r][c];
			}
			avg = (double) sum / count;
			System.out.println("Row " + (r + 1) + " Average: " + avg);
		}
		System.out.println();
	}
	//shows column average
	public static void colAvg(int[][] arr){
		int sum = 0, count = 0;
		double avg;

		for(int r = 0; r < arr[0].length; r++){
			sum = 0;
			count = 0;
			for(int c = 0; c < arr.length; c++,count ++){
				sum += arr[c][r];
			}
			avg = (double) sum / count;
			System.out.print("Column " + (r + 1) + " Average: " + avg);
			System.out.println();
		}
		System.out.println();
	}
	//shows average of diagonals
	public static void majMinAvg(int[][] arr){
		double major = majAvg(arr);
		double minor = minAvg(arr);
		double avg = (major + minor) / 2;
		System.out.println("Average of Major and Minor Diagonals: " + avg);

	}
	//returns average of major diagonals
	public static double majAvg(int[][] arr){
		int sum = 0, count = 0;
		double avg = 0;

		for(int r = 0; r < arr.length; r++){
			for(int c = 0; c < arr[r].length; c++){
				if(c == r){
					sum += arr[r][c];
					count++;
				}
			}
		}
		avg = (double) sum / count;
		return avg;
	}
	//returns average of minor diagonals
	public static double minAvg(int[][] arr){
		int sum = 0, count = 0;
		double avg = 0;

		for(int r = 0, c = arr[r].length - 1; r < arr.length && c >= 0; r++, c--, count++){
			sum += arr[r][c];
		}
		avg = (double) sum / count;
		return avg;
	}
}
