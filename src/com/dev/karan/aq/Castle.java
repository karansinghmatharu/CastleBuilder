package com.dev.karan.aq;

import java.util.Scanner;
/**
 * 
 * @author KaranDeepSingh
 *
 */
public class Castle {

	public static void main(String[] args) {
		// int[] land = readFromTerrain();
		int[] land = readFromScanner();
		int castles = buildCastles(land);
		System.out.println("Castles built by Aequilibrium on the land is : "
				+ castles);

	}

	/**
	 * This method returns predefined array for defining a terrian
	 * 
	 * @return
	 */
	private static int[] readFromTerrain() {
		int[] land = { 2, 6, 4, 5, 6, 1, 1, 1, 6, 6, 3, 2, 3, 6, 5, 4, 6, 4, 5, 1, 1 };
		// int[] land = { 4, 2, 3, 4, 1, 1, 1, 6, 6, 5, 6, 1, 4, 3, 6, 1, 1 };
		// int[] land = { 2, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		// int[] land = { 2, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
		// int[] land = { 2, 1, 3};
		// int[] land = { 1, 2};
		// int[] land = {};
		// int[] land = null;
		return land;

	}

	/**
	 * This method returns array of land on basis of specified land(array) size
	 * and array input
	 * 
	 * @return
	 */
	private static int[] readFromScanner() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the land size ");
		int elements = scanner.nextInt();
		int land[] = new int[elements];
		System.out.println("Enter the array of land terrain : ");
		for (int i = 0; i < elements; i++) {
			land[i] = scanner.nextInt();

		}
		scanner.close();
		return land;
	}

	/**
	 * This method returns the number of castles that can be built in a terrain
	 * 
	 * @param land
	 * @return
	 */
	private static int buildCastles(int[] land) {
		int sizeOfLand = land.length;
		if (land == null || sizeOfLand == 0)
			return 0;
		int numOfPeaks = countPeaks(land, sizeOfLand);
		int numOfValleys = countValleys(land, sizeOfLand);
		int totalCastles = 0;
		totalCastles = numOfPeaks + numOfValleys + 1;// +1 for the non empty
														// array
		return totalCastles;
	}

	/**
	 * This method returns the number of peaks in a terrain
	 * 
	 * @param land
	 * @param size
	 * @return
	 */
	private static int countPeaks(int[] land, int size) {
		int count = 0, peaks = 0;
		for (int i = 1; i + 1 < size; i++) {
			if ((land[i] > land[i - 1]) && (land[i] > land[i + 1])) {
				count++;

			} else if (land[i] == land[i + 1]) {
				int temp = land[i];
				int k = i - 1;
				for (int j = i; j + 1 < size; j++) {
					if (land[j + 1] == temp) {
						i++;
					} else {
						break;
					}
				}
				if ((i + 1 < size) && (land[i] > land[k])
						&& (land[i] > land[i + 1]))
					count++;
			}
			if (count > peaks) {
				peaks = count;
			}
		}
		return peaks;
	}

	/**
	 * This method returns the number of valleys in a terrain
	 * 
	 * @param land
	 * @param size
	 * @return
	 */
	private static int countValleys(int[] land, int size) {
		int count = 0, valleys = 0;
		for (int i = 1; i + 1 < size; i++) {
			if ((land[i] < land[i - 1]) && (land[i] < land[i + 1])) {
				count++;

			} else if (land[i] == land[i + 1]) {
				int temp = land[i];
				int k = i - 1;
				for (int j = i; j + 1 < size; j++) {
					if (land[j + 1] == temp) {
						i++;
					} else {
						break;
					}
				}
				if ((i + 1 < size) && (land[i] < land[k])
						&& (land[i] < land[i + 1]))
					count++;
			}
			if (count > valleys) {
				valleys = count;
			}
		}
		return valleys;
	}

}
