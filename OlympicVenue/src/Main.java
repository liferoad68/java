/**
 * オリンピック開催国パターン計算
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String line = cin.nextLine();
		cin.close();

		int num = 0;
		try {
			num = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.out.println("error");
			return;
		}
		System.out.println(calcOlympicVenue(num));
	}

	public static int calcOlympicVenue(int num) {
		if (num == 1 || num == 2) {
			return 1;
		}
		if (num == 3) {
			return 3;
		}
		return num + (num * calcOlympicVenue(num - 1));
	}
}

