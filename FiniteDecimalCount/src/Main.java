
/**
 * 有限小数カウント
自然数 n に対し、1 ≦ a ≦ n，1 ≦ b ≦ n を満たし、かつ小数で表した a÷b が有限小数となるような自然数の組 (a, b) の個数を F(n) と定義します。
（有限小数…小数点以下の桁数が有限である小数。）
 
例えば、F(3) ＝ 7 です。
下記の (a, b) の組のうち、有限小数は太字で記した 7 個です。
 
1÷1＝1，　1÷2＝0.5，　1÷3＝0.33333…
2÷1＝2，　2÷2＝1，　　2÷3＝0.66666…
3÷1＝3，　3÷2＝1.5，　3÷3＝1
 
同様に、F(5)＝21，F(10)＝68，F(100)＝2185 となることが確かめられます。
 
 
標準入力から、自然数 n（1 ≦ n ≦ 104）が与えられます。
標準出力に F(n) の値を出力するプログラムを書いてください。
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String line;
		for (; cin.hasNext();) {
			line = cin.nextLine();

			// 計測開始
			long start = System.currentTimeMillis();
			int num = 0;
			try {
				num = Integer.parseInt(line.toUpperCase());
			} catch (NumberFormatException e) {
				System.out.println("input error");
				break;
			}
			System.out.println(calcFiniteDecimalCount(num));

			// 計測終了
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "ms");
		}
		cin.close();
	}

	/**
	 * 有限小数カウント計算
	 * 
	 * @param num
	 * @return
	 */
	public static String calcFiniteDecimalCount(int num) {
		int count = 0;
		for (int a = 1; a <= num; a++) {
			for (int b = 1; b <= num; b++) {
				if (isFiniteDecimal(a, b)) {
					count++;
				}
			}
		}
		return String.valueOf(count);
	}

	/**
	 * 有限小数判定
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isFiniteDecimal(int a, int b) {
		// a/b を約分
		int denominator = getDenominatorReduce(a, b);

		// 分母の素因数分解数値が全て2または5か判定
		return isPrimeFactorizationAll2or5(denominator);
	}

	/**
	 * 約分して分母を返す
	 * 
	 * @param a
	 * @param b
	 * @return a/bを約分した分母
	 */
	public static int getDenominatorReduce(int a, int b) {
		int i = (a > b) ? b : a;
		for (int j = i; j > 1; j--) {
			if ((a % j == 0) && (b % j == 0)) {
				a = a / j;
				b = b / j;
			}
		}
		return b;
	}

	/**
	 * 分母の素因数分解数値が全て2または5か判定
	 * 
	 * @param denominator
	 * @return
	 */
	public static boolean isPrimeFactorizationAll2or5(int denominator) {
		// 分母が 1,2,5であれば有限小数
		switch (denominator) {
		case 1:
		case 2:
		case 5:
			return true;
		default:
			// 性能向上のため、3,7で割り切れる場合、有限小数でない
			// if ((denominator % 3) == 0) {
			// return false;
			// }
			// if ((denominator % 7) == 0) {
			// return false;
			// }

			// 性能向上 > 向上ならず
			// if ((denominator % 50) == 0) {
			// return isPrimeFactorizationAll2or5(denominator / 50);
			// }
			// if ((denominator % 20) == 0) {
			// return isPrimeFactorizationAll2or5(denominator / 20);
			// }
			// if ((denominator % 10) == 0) {
			// return isPrimeFactorizationAll2or5(denominator / 10);
			// }

			// 2,5で割り切れる場合、再帰
			if ((denominator % 5) == 0) {
				return isPrimeFactorizationAll2or5(denominator / 5);
			}
			if ((denominator % 2) == 0) {
				return isPrimeFactorizationAll2or5(denominator / 2);
			}
		}
		return false;
	}
}
