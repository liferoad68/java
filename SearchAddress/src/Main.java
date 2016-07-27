
/**
 * C005:アドレス調査
【問題】
あなたはあるソフトウェアの開発でIPアドレスを入力してもらう機能の一部を開発しています。
入力は手入力で「.」と「数字」で構成された長さNの文字列が入力されます。

入力されているIPアドレスが書式に合っているか判定して、合っていればTrue、
違っていればFalseと標準出力で出力するプログラムを作成してください。

判別すべきIPアドレスはIPv4で定義された範囲のIPアドレスとします。書式は以下のようになります。

.で区切られた10進数の4つの数で表されます。
数の範囲は0から255までとします。
例:
100.23.103.20
123.11.22.33
14.33.103.20
102.233.13.2
評価ポイント
10個のテストケースを入力し、正答数と解答の提出までに要した時間を測定し得点が決まります。 
※制限時間を超えるとテストケースが通っても失格(0点)となります。
※提出いただいたコードは複数回実行され、一度の実行では1つのテストケースのみ入力
得点の計算方法：正解数得点(50点) ＋ 正解率×回答時間得点(20分以内で50点、40分で25点、60分で0点と線形に点数が落ちます)
複数のテストケースで正しい出力がされるか評価（+50点）
解答までの速さ評価（+50点）
入力される値
・1行目には入力されるIPアドレスの数Mが入力されます。
・2行目以降には「.」と「数字」のみで構成された長さNの文字列がM行入力されます。
文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
期待する出力
IPv4のアドレスとして正しいのならTrue,違う場合はFalseと改行区切りでM行出力してください。
条件
1 ≦ N ≦ 100
1 ≦ M ≦ 100
入力例1
4
192.168.0.1
192.168.0.2
192.168.0.3
192.168.0.4
出力例1
True
True
True
True
入力例2
4
192.400.1.10.1000...
4.3.2.1
0..33.444...
1.2.3.4
出力例2
False
True
False
True

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
			if (isIPAddress(readLine)) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
	}

	public static boolean isIPAddress(String str) {
		String[] ipNumbers = str.split("\\.");
		int ipNumbersLength = ipNumbers.length;
		if (ipNumbersLength != 4) {
			return false;
		}
		for (int i = 0; i < ipNumbersLength; i++) {
			int ipNumber = 0;
			try {
				ipNumber = Integer.parseInt(ipNumbers[i]);
			} catch (NumberFormatException e) {
				return false;
			}
			if (ipNumber < 0) {
				return false;
			} else if (ipNumber > 255) {
				return false;
			}
		}
		return true;
	}
}
