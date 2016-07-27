
/**
 * B012:チェックディジット
【問題】
クレジットカード番号は16桁の番号で表すことができますが、この番号は以下の性質を持っています。

一番右の桁を1桁目として、

・偶数桁の数字をそれぞれ2倍し総和をとったものをeven 
（ただし、2倍したあと2桁の数字になるものは、1の位と10の位の数を足して1桁の数字にしたあと、総和をとる）
・奇数桁の数字の総和をとったものをodd
とすると、even + odd は10 で必ず割り切れます。

1桁目がX と書かれた16桁の番号が複数与えられるので、それぞれに対し、上記性質をみたすようにX に入る数字を求めてください。

評価ポイント
10回のテストケースで、正答率、実行速度、メモリ消費量をはかり得点が決まります。
より早い回答時間で提出したほうが得点が高くなります。
複数のテストケースで正しい出力がされるか評価（+50点）
解答までの速さ評価（+50点）
入力される値
入力は以下のフォーマットで与えられます。

n　　　#入力されるクレジットカードの総数
a_1　　#1番目のクレジットカード番号
a_2　　#....
a_3　　#....
...
a_n　　#n番目のクレジットカード番号
それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
期待する出力
それぞれのa_i に対し、X に入る数字を一行に出力してください。出力は全部でn 行になります。

最後は改行し、余計な文字、空行を含んではいけません。
条件
すべてのテストケースで以下の条件を満たします。

1 ≦ n ≦ 100
a_i (1 ≦ i ≦ n) は長さ16の文字列です。
1文字目から15文字目は0から9までのいずれかの数字が書かれており、16文字目はX (アルファベット大文字のエックス) が書かれています。
入力例1
1
846087729128569X
出力例1
7
入力例2
4
628381026148991X
511070105176715X
273492510450813X
670891979616350X
出力例2
5
9
7
2
入力例3
5
091180422478189X
774123801013511X
973736969204716X
793180803472918X
358682935182058X
出力例3
1
4
0
1
2

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// 自分の得意な言語で
		// Let's チャレンジ！！
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int M = Integer.parseInt(line);
		for (int i = 0; i < M; i++) {
			String readLine = br.readLine().trim();
			System.out.println(getCheckDigit(readLine));
		}
	}

	public static int getCheckDigit(String str) {
		int n15DigitSum = getEvenSum(str) + getOddSum(str);
		int mod = n15DigitSum % 10;
		if (mod == 0) {
			return 0;
		}
		int n16 = 10 - mod;
		return n16;
	}

	public static int getEvenSum(String str) {
		int sum = 0;
		for (int i = 0; i < str.length() - 1; i = i + 2) {
			String numStr = str.substring(i, i + 1);
			int num = Integer.parseInt(numStr);
			int num2 = num * 2;
			sum = sum + addDigit(num2);
		}
		return sum;
	}

	public static int addDigit(int num) {
		if (num < 10) {
			return num;
		}
		String numStr = String.valueOf(num);
		int num1 = Integer.parseInt(numStr.substring(0, 1));
		int num2 = Integer.parseInt(numStr.substring(1, 2));

		return addDigit(num1 + num2);
	}

	public static int getOddSum(String str) {
		int sum = 0;
		for (int i = 1; i < str.length() - 1; i = i + 2) {
			String numStr = str.substring(i, i + 1);
			int num = Integer.parseInt(numStr);
			sum = sum + num;
		}
		return sum;
	}
}
