
/**
 * 排他的n乗数
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String line = cin.nextLine();
		cin.close();

		// 入力整数
		long m = 0;
		// 入力乗数
		long n = 0;
		try {
			String[] inputStr = line.split(",");
			m = Long.parseLong(inputStr[0]);
			n = Long.parseLong(inputStr[1]);
		} catch (NumberFormatException e) {
			System.out.println("error");
			return;
		}
		System.out.println(calcMaxExclusiveMultiplier(m, n));
	}

	public static String calcMaxExclusiveMultiplier(long m, long n) {
		for (long max = m - 1; max >= 1; max--) {
			if (isMaxExclusiveMultiplier(max, n)) {
				return String.valueOf(max);
			}
		}
		return "-";
	}

	public static boolean isMaxExclusiveMultiplier(long m, long n) {

		DecimalFormat df = new DecimalFormat("####################");
		String strMultiplier = df.format(Math.pow(m, n));
		String strM = df.format(m);
		List<String> listM = new ArrayList<String>();

		for (int num = 0; num < strM.length(); num++) {

			String strNum = strM.substring(num, num + 1);

			if (listM.contains(strNum)) {
				return false;
			}
			listM.add(strNum);

			if (strMultiplier.indexOf(strNum) != -1) {
				return false;
			}
		}
		return true;
	}
}
