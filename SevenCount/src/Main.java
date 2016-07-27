
/**
 * 「7」の数を数えよう
【問題】
1からnまで連続する正の整数があります。
それらの中に、「7」がいくつあるかを数えてください。

【例】
n = 99とすると、
1 2 3 4 5 6 7 8 9 10
11 12 13 14 15 16 17 18 19 20
21 22 23 24 25 26 27 28 29 30
31 32 33 34 35 36 37 38 39 40
41 42 43 44 45 46 47 48 49 50
51 52 53 54 55 56 57 58 59 60
61 62 63 64 65 66 67 68 69 70
71 72 73 74 75 76 77 78 79 80
81 82 83 84 85 86 87 88 89 90
91 92 93 94 95 96 97 98 99

「7」を含む値は、
7 17 27 37 47 57 67 70 71 72 73 74 75 76 77 78 79 87 97
の19個ですが、77には「7」が2つ含まれています。
ですので、「7」の数は19個ではなく、20個と答えてください。なお、nは32bit整数に収まるものとします。

【入出力サンプル】
Input

7
99


Output

1
20


 */
import java.util.Scanner;

public class Main {

	private static final int COUNT_NUMBER = 7;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String line;
		for (; cin.hasNext();) {
			line = cin.nextLine();

			// 計測開始
			// long start = System.currentTimeMillis();
			try {
				Integer.parseInt(line.toUpperCase());
			} catch (NumberFormatException e) {
				System.out.println("input error");
				break;
			}
			System.out.println(calcCountNumber(line));

			// 計測終了
			// long end = System.currentTimeMillis();
			// System.out.println((end - start) + "ms");
		}
		cin.close();
	}

	/**
	 * 数値カウント計算
	 * 
	 * @param num
	 * @return
	 */
	public static String calcCountNumber(String strNum) {
		int sum = 0;
		for (int i = 0; i < strNum.length(); i++) {
			int num = Character.getNumericValue(strNum.charAt(i));
			sum = sum + getNumberCount(num, strNum.length() - i, strNum.substring(i + 1));
		}
		return String.valueOf(sum);
	}

	/**
	 * 数値文字取得
	 * 
	 * @param num
	 * @param digit
	 * @return
	 */
	public static int getNumberCount(int num, int digit, String strDigit1) {
		int count = 0;
		if (num < COUNT_NUMBER) {
			// 数値 < 7の場合
			// 数値 * (桁数 - 1) * (10 ^ (桁数 - 2))
			count = (int) (num * (digit - 1) * Math.pow(10, (digit - 2)));
		} else if (num == COUNT_NUMBER) {
			// 数値 = 7の場合
			// 数値 * (桁数 - 1) * (10 ^ (桁数 - 2)) + １桁前の数値 + 1
			int digit1 = "".equals(strDigit1) ? 0 : Integer.parseInt(strDigit1);
			count = (int) (num * (digit - 1) * Math.pow(10, (digit - 2))) + digit1 + 1;
		} else {
			// 数値 > 7の場合
			// 数値 * (桁数 - 1) * (10 ^ (桁数 - 2)) + (10 ^ (桁数 - 1)
			count = (int) (num * (digit - 1) * Math.pow(10, (digit - 2)) + Math.pow(10, (digit - 1)));
		}
		return count;
	}
}
