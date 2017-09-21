package homework;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Joshua Lazaro
 * 
 * Cost Of Manufatured Devices
 */

public class HW08P02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int devices, compTypes, compNum;
		
		int[] numArray;
		double[] priceArr;
		int[][] compArr;
		
		System.out.print("How many electronic devices does the company produce?: ");
		devices = input.nextInt();
		
		
		System.out.print("How many different component types are used?: ");
		compTypes = input.nextInt();
		
		priceArr = new double[compTypes];
		
		numArray = new int[compTypes];
		
		numArray = listComp(numArray);
		
		System.out.print("What are the prices of each component?: ");
		priceArr = getPrices(priceArr);
		
		System.out.print("Enter the number of components used to create each device \n(enter the table data): ");
		compArr = new int[devices][compTypes];
		compArr = getMatrix(compArr);
		
		costComp(numArray, priceArr);
		
		showTable(compArr, numArray);
		
		totalCost(compArr, priceArr);
	}
	public static double[] getPrices(double[] arr){
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = in.nextDouble();
		}
		return arr;
	}
	public static int[] listComp(int[] arr){
		for(int i = 0; i < arr.length; i++){
			arr[i] = i + 1;
		}
		return arr;
	}
	public static void costComp(int[] label, double[] price){
		DecimalFormat money = new DecimalFormat("$#,###.00");
		System.out.println("\n\nCost Per Component:");
		for(int i = 0; i < 2; i++){
			if(i == 0){
				for(int j = 0; j < label.length; j++){
					System.out.print(label[j] + "\t");
				}
			}
			else if(i == 1){
				for(int j = 0; j < price.length; j++){
					System.out.print(money.format(price[j]) + "\t");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int[][] getMatrix(int[][] arr){
		Scanner in = new Scanner(System.in);
		
		for(int r = 0; r < arr.length; r++){
			for(int c = 0; c < arr[r].length; c++){
				arr[r][c] = in.nextInt();
			}
		}
		return arr;
	}
	public static void showTable(int[][]arr, int[] numbers){
		System.out.println("Table Data:");
		System.out.println("Device Number\tComponent Number");
		System.out.print("\t\t");
		for(int i = 0; i < numbers.length; i++){
			System.out.print((i + 1) + "\t");
		}
		System.out.println();
		System.out.print("-----------------");
		for(int i = 0; i < numbers.length - 1; i ++){
			System.out.print("--------");
		}
		System.out.println();
		
		for(int r = 0; r < arr.length; r++){
			System.out.print((r + 1) + "\t\t");
			for(int c = 0; c < arr[r].length; c++){
				System.out.print(arr[r][c] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void totalCost(int[][] table, double[] priceArr){
		DecimalFormat money = new DecimalFormat("S#,###.00");
		double sum = 0;
		
		System.out.println("Total Cost Per Device:");
		for(int r = 0; r < table.length; r++){
			sum = 0;
			for(int c = 0; c < table[r].length; c++){
				sum += table[r][c] * priceArr[c];
			}
			System.out.println("Device " + (r + 1) + ": " + money.format(sum));
		}
	}
}
