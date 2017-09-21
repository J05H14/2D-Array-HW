package homework;

import java.util.Random;
import java.util.Scanner;

/*
 * Joshua Lazaro
 * 
 * Repeating items
 */

public class HW08P03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int size;
		char[][] array;

		System.out.print("Enter Matrix Size: ");
		size = input.nextInt();

		array = new char[size][size];
		array = fillArray(array);
		
		System.out.println();

		printArray(array);

		allRow(array, size);
		
		allCol(array, size);
		
		allMaj(array, size);
		
		allMin(array, size);
	}
	public static char[][] fillArray(char[][] arr){
		Random randChar = new Random();
		int character;
		char ch;

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				character = randChar.nextInt(2);
				if(character == 0){
					ch = 'o';
				}
				else{
					ch = 'x';
				}
				arr[i][j] = ch;
			}
		}
		return arr;
	}
	public static void printArray(char[][] arr){
		for(int r = 0; r < arr.length; r++){
			for(int c = 0; c < arr[r].length; c++){
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void allRow(char[][] arr, int size){
		int length;

		for(int r = 0; r < arr.length; r++){
			length = 1;
			for(int c = 0; c < arr[r].length - 1; c++){
				if(arr[r][c] == arr[r][c + 1]){
					length++;
				}
				if(length == size){
					System.out.print("All " + arr[r][c] + "'s in row " + (r + 1) + "\n");
				}
			}
		}
	}
	public static void allCol(char[][] arr, int size){
		int xNum = 0, oNum = 0;
		
		for(int r = 0; r < arr[0].length; r++){
			xNum = 0;
			oNum = 0;
			for(int c = 0; c < arr.length; c++){
				if(arr[c][r] == 'x'){
					xNum++;
				}
				if(arr[c][r] == 'o'){
					oNum++;
				}
			}
			if(xNum == size){
				System.out.println("All x's in column " + (r + 1));
			}
			else if(oNum == size){
				System.out.println("All o's in column " + (r + 1));
			}
		}
	}
	public static void allMaj(char[][] arr, int size){
		int length = 1;
		for(int r = 0; r < arr.length - 1; r++){
			for(int c = 0; c < arr.length - 1; c++){
				if(r == c){
					if(arr[r + 1][c + 1] == arr[r][c]){
						length++;
					}
				}
			}
		}
		if(size == length){
			System.out.println("All " + arr[0][0] + "'s in major diagonal");
		}
	}
	public static void allMin(char[][] arr, int size){
		int xNum = 0, oNum = 0;
		
		for(int r = 0, c = arr.length - 1; r < arr.length; r++, c--){
			if(arr[r][c] == 'x'){
				xNum++;
			}
			else if(arr[r][c] == 'o'){
				oNum++;
			}
		}
		if(xNum == size){
			System.out.println("All x's in minor diagonal");
		}
		else if(oNum == size){
			System.out.println("All o's in minor diagonal");
		}
	}
}
