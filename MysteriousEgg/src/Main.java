
/**
 * D046:不思議なタマゴ
【問題】
持ったまま一定の距離を歩くと孵化する不思議なタマゴがあります。あなたはこのタマゴをなるべくいっぺんに孵化させようと思い、3 つをまとめて持っていくことにしました。これらをすべて孵化させるのに最低限必要な歩行距離を求めてください。

例)
孵化させるのに必要な歩行距離
タマゴ 1: 1 km
タマゴ 2: 3 km
タマゴ 3: 5 km
→ 最低限必要な歩行距離: 5 km (入力例 1 に対応)
評価ポイント
10回のテストケースで、正答率、実行速度、メモリ消費量をはかり得点が決まります。
より早い回答時間で提出したほうが得点が高くなります。
複数のテストケースで正しい出力がされるか評価（+50点）
解答までの速さ評価（+50点）
入力される値
入力は以下のフォーマットで与えられます。

d_1 d_2 d_3
3 つのタマゴそれぞれを孵化させるのに必要な歩行距離(km)を表す整数 d_1, d_2, d_3 がここの順に半角スペース区切りで与えられます。

入力値最終行の末尾に改行が１つ入ります。

標準入力からの値取得方法はこちらをご確認ください
期待する出力
3 つの不思議なタマゴをすべて孵化させるのに最低限必要な歩行距離(km)を出力してください。
出力の最後に改行を 1 つ入れ、余計な空白、改行を含んではいけません。
条件
すべてのテストケースで以下の条件を満たします。
入力される値は全て整数

・1 ≦ d_1, d_2, d_3 ≦ 100
入力例1
1 3 5
出力例1
5
入力例2
2 5 5
出力例2
5

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(getShortestDistance(br.readLine().trim()));
	}

	public static int getShortestDistance(String line) {
		int max = 0;
		String[] lineStrings = line.split(" ");
		for (int i = 0; i < lineStrings.length; i++) {
			int n = Integer.valueOf(lineStrings[i]);
			if (max < n) {
				max = n;
			}
		}
		return max;
	}
}