
/**
 * A004:あみだくじ
【問題】
n本の縦線から成るあみだくじがあります。
このあみだくじにはm本の横線が引いてあります。
i番目の横線は、左からa_i番目の縦線の上からb_i[cm]の箇所と、
その1つ右の縦線の上からc_i[cm]の箇所をつないでいます。
縦線の長さは全てL[cm]です。
あみだくじ説明図
あなたは、あみだくじを行った後最終的に一番左に到達する縦線を選びたいと思っています。
どの縦線を選択すればよいのかを出力して下さい。
評価ポイント
10個のテストケースを入力し、正答数と解答の提出までに要した時間を測定し得点が決まります。 
※制限時間を超えるとテストケースが通っても失格(0点)となります。
※提出いただいたコードは複数回実行され、一度の実行では1つのテストケースのみ入力
得点の計算方法：正解数得点(50点) ＋ 正解率×回答時間得点(2時間以内で50点、4時間で25点、6時間で0点と線形に点数が落ちます)
複数のテストケースで正しい出力がされるか評価（+50点）
解答までの速さ評価（+50点）
入力される値
1行目では縦線の長さL、縦線の本数n、横線の本数mがこの順で半角スペース区切りで与えられます。
2行目からm+1行目までのi+1行目では、a_i、b_i、c_iがこの順で半角スペース区切りで与えられます。
入力される値は全て整数です。入力最終行には改行コードが1つ入ります。
文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
期待する出力
最終的に一番左に到達する縦線が左から数えて何番目なのかを、一行で出力してください。
条件
5つのテストケースにおいて、以下の条件を満たします。
2≦L≦100
2≦n≦100


全てのテストケースにおいて、以下の条件を満たします。
2≦L≦10,000
2≦n≦1,000
0≦m≦10,000
1≦a_i≦n-1
1≦b_i, c_i≦L-1
2つ以上の横線が交差する、または端点を共有することはない。
入力例1
※ # 以降はコメントです。

7 4 5# L(縦線の長さ)=7、n(縦線の本数)=4、m(横線の本数)=5
1 3 1# 1番目の横線　1番目の縦線の上から3cmの位置から、2番目の縦線の上から1cmの位置に線が引かれる
3 2 2# 2番目の横線　3番目の縦線の上から2cmの位置から、4番目の縦線の上から2cmの位置に線が引かれる
2 3 5# 3番目の横線　2番目の縦線の上から3cmの位置から、3番目の縦線の上から5cmの位置に線が引かれる
3 4 4# 4番目の横線　3番目の縦線の上から4cmの位置から、4番目の縦線の上から4cmの位置に線が引かれる
1 6 6# 5番目の横線　1番目の縦線の上から6cmの位置から、2番目の縦線の上から6cmの位置に線が引かれる
出力例1
3
この入力例１のあみだくじは次のようになっています。左から3番目の線を選ぶと一番左の線に到達するので'3'を出力します。
あみだくじ



入力例2
5 5 8
3 3 4
1 3 2
4 2 2
2 1 2
2 4 4
3 1 1
1 4 3
4 3 4
出力例2
1

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	// あみだくじマップ生成
	private static Map<GhostLeg, GhostLeg> map = new HashMap<GhostLeg, GhostLeg>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine().trim();
		String[] line1Strings = line1.split(" ");
		// 縦線の長さ
		int l = Integer.parseInt(line1Strings[0]);
		// 縦線の本数
		int n = Integer.parseInt(line1Strings[1]);
		// 横線の本数
		int m = Integer.parseInt(line1Strings[2]);

		for (int i = 0; i < m; i++) {
			String line = br.readLine().trim();
			makeGhostLegMap(l, n, m, line);
		}

		System.out.println(calcGhostLegMap(l, n, m));
	}

	public static void makeGhostLegMap(int l, int n, int m, String line) {
		String[] lineStrings = line.split(" ");
		// 縦線番号
		int a_1 = Integer.parseInt(lineStrings[0]);
		// 縦線の長さ
		int b_1 = Integer.parseInt(lineStrings[1]);
		// 右隣の縦線の長さ
		int c_1 = Integer.parseInt(lineStrings[2]);

		GhostLeg left = new GhostLeg(a_1, b_1);
		GhostLeg right = new GhostLeg(a_1 + 1, c_1);
		map.put(left, right);
		map.put(right, left);
	}

	public static int calcGhostLegMap(int l, int n, int m) {
		// 現在の縦線番号
		int nowLine = 1;
		// 現在の縦線の長さ位置
		int nowLength = l;

		return calcGhostLegMap(nowLine, nowLength);
	}

	public static int calcGhostLegMap(int nowLine, int nowLength) {
		for (int i = nowLength - 1; i > 0; i--) {
			GhostLeg now = new GhostLeg(nowLine, i);
			if (map.containsKey(now)) {
				GhostLeg next = map.get(now);
				return calcGhostLegMap(next.getLine(), next.getLength());
			}
		}
		return nowLine;
	}
}

class GhostLeg {
	// 縦線
	private int line;
	// 長さ
	private int length;

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public GhostLeg() {
	}

	public GhostLeg(int line, int length) {
		this.line = line;
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + line;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GhostLeg other = (GhostLeg) obj;
		if (length != other.length)
			return false;
		if (line != other.line)
			return false;
		return true;
	}
}
