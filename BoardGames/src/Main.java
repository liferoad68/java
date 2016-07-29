
/**
 * A003: board games
【問題】
8x8の盤上で行われたリバーシのログが、以下の様な形式で与えられます。

60
B 4 5
W 5 6
B 3 4
…
先頭の数字は、石が置かれた回数(=2行目以降のログの行数)を表します。
2行目以降の各行において、Bは黒い石のプレイヤーが、Wは白い石のプレイヤーが
それぞれ石を置いたことを表します。必ずBが先手です。
2つの数字は、それぞれ石を置いた場所のx座標とy座標をこの順で1以上8以下で表しています。

パスの場合は下記のようなログになります。
B 8 5
W 8 6
W 6 8
B 2 4
reversi
入力されたログから元のゲームをシミュレートし、最終的にどちらが勝ったのかを判定するプログラムを書いてください。

リバーシルール

最初に黒石と白石を盤の中央に２個ずつ交差するようにおいて黒が先手で対局を開始します。
初期配置は図の通り、右上が黒石になるよう置きます。
必ず相手の１つ以上の石をはさめる所にだけ石を置き、
はさんだ石を全部裏返して自分の色の石にします。
裏返した石ではさんだ相手の石があっても，その石はそのままにします。
黒と白が交互に打ち進め、一方が打てる所がない場合はパスとなり、
うてる所ができるまでもう一方が連続して打ちます。
盤面が全部埋まるか、黒白ともに相手の石をはさめなくなった時が 対局の
終わりで、その時に自分の色の石の数の多い方が勝ちとなります。
（参考）リバーシ詳細ルール
http://ja.wikipedia.org/wiki/オセロ_(遊戯)
評価ポイント
10個のテストケースを入力し、正答数と解答の提出までに要した時間を測定し得点が決まります。
※制限時間を超えるとテストケースが通っても失格(0点)となります。
※提出いただいたコードは複数回実行され、一度の実行では1つのテストケースのみ入力
得点の計算方法：正解数得点(50点) ＋ 正解率×回答時間得点(2時間以内で50点、4時間で25点、6時間で0点と線形に点数が落ちます)
複数のテストケースで正しい出力がされるか評価（+50点）
解答までの速さ評価（+50点）
入力される値
問題文中に指定された形式で、リバーシのログが入力されます。
期待する出力
次に示す形式に従い1行で出力してください。
黒が勝った時
xx-yy The black won!
白が勝った時
xx-yy The white won!
引き分けの時
xx-yy Draw!
但し、xxとyyはそれぞれ最終的な黒と白の石の数であり、9以下の場合は先頭に0を補って必ず2桁の整数として出力してください。
条件
全てのテストケースにおいて、入力されるログは正常にルールに則りゲームが行われた時のものであり、
最後の盤面の状態は前述の終了条件を満たしているものとします。
入力例
60
B 6 5
W 4 6
B 3 4
W 4 3
B 3 5
W 6 6
B 5 6
W 2 6
B 2 5
W 1 6
B 2 4
W 7 6
B 7 5
W 6 4
B 5 3
W 6 3
B 6 2
W 4 2
B 3 2
W 2 3
B 3 6
W 3 7
B 4 7
W 5 7
B 7 7
W 6 7
B 5 8
W 4 8
B 3 8
W 2 8
B 2 7
W 1 7
B 1 8
W 7 8
B 6 8
W 8 7
B 8 6
W 8 4
B 8 5
W 8 8
B 8 3
W 5 2
B 3 3
W 7 4
B 7 3
W 7 2
B 8 2
W 7 1
B 8 1
W 2 2
B 1 5
W 1 4
B 1 3
W 1 2
B 6 1
W 5 1
B 4 1
W 3 1
B 2 1
W 1 1
出力例
38-26 The black won!
入力例2
14
B 4 3
W 5 3
B 6 3
W 3 3
B 3 4
W 3 5
B 4 6
W 7 3
B 6 5
W 7 5
B 5 6
W 5 7
B 6 4
W 7 4
出力例2
00-18 The white won!
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        ReversiSimulator rs = new ReversiSimulator();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(br.readLine().trim());
        for (int i = 0; i < num; i++) {
            String lineString = br.readLine().trim();
            // TODO:CommentOut
            // System.out.println("");
            // System.out.print(lineString);
            String[] lineStrings = lineString.split(" ");
            rs.simulate(lineStrings[0], Integer.parseInt(lineStrings[1]), Integer.parseInt(lineStrings[2]));
        }
        System.out.println(rs.getResultString());
    }
}

/**
 * リバーシシミュレーター
 *
 * @author lifer
 *
 */
class ReversiSimulator {
    // リバーシ
    private Reversi reversi = new Reversi();

    public ReversiSimulator() {
    }

    /**
     * シミュレート
     *
     * @param b_or_w
     * @param x
     * @param y
     */
    public void simulate(String b_or_w, int x, int y) {
        if ("B".equals(b_or_w)) {
            simulate(-1, x - 1, y - 1);
        } else if ("W".equals(b_or_w)) {
            simulate(1, x - 1, y - 1);
        }

    }

    /**
     * 結果文字列取得
     *
     * @return
     */
    public String getResultString() {
        int black = 0;
        int white = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.reversi.isWhite(i, j)) {
                    white++;
                } else if (this.reversi.isBlack(i, j)) {
                    black++;
                }
            }
        }
        String resultFormat = getResultFormat(black, white);
        if (white < black) {
            return String.format("%s The black won!", resultFormat);
        } else if (white > black) {
            return String.format("%s The white won!", resultFormat);
        }

        return String.format("%s Draw!", resultFormat);
    }

    /**
     * シミュレート
     *
     * @param b_or_w
     * @param xIndex
     * @param yIndex
     */
    private void simulate(int b_or_w, int xIndex, int yIndex) {
        // マスに配置
        this.reversi.setBoards(xIndex, yIndex, b_or_w);

        // 配置したマスの左が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, -1, 0);
        // 配置したマスの左上が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, -1, -1);
        // 配置したマスの上が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, 0, -1);
        // 配置したマスの右上が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, 1, -1);
        // 配置したマスの右が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, 1, 0);
        // 配置したマスの右下が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, 1, 1);
        // 配置したマスの下が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, 0, 1);
        // 配置したマスの左下が異なる色か
        simulateNext(b_or_w, xIndex, yIndex, -1, 1);
    }

    /**
     * シミュレート隣
     *
     * @param b_or_w
     * @param xIndex
     * @param yIndex
     */
    private void simulateNext(int b_or_w, int xIndex, int yIndex, int xDirection, int yDirection) {
        // 配置したマスの隣が存在するか
        if (!this.reversi.hasIndex(xIndex + xDirection, yIndex + yDirection)) {
            return;
        }
        // 配置したマスの隣が異なる色か
        if (this.reversi.isSame(xIndex + xDirection, yIndex + yDirection, (b_or_w * -1))) {
            simulateReverse(b_or_w, xIndex, yIndex, xDirection, yDirection);
        }
    }

    /**
     * 裏返しシミュレート
     *
     * @param b_or_w
     * @param xIndex
     * @param yIndex
     * @param xDirection
     * @param yDirection
     */
    private void simulateReverse(int b_or_w, int xIndex, int yIndex, int xDirection, int yDirection) {
        for (int i = xIndex + (xDirection * 2), j = yIndex + (yDirection * 2); ((this.reversi.hasIndex(i, j))); i = i + xDirection, j = j + yDirection) {
            if (this.reversi.isSame(i, j, b_or_w)) {
                // 裏返す
                reverseBoards(b_or_w, xIndex, yIndex, xDirection, yDirection, i, j);
                return;
            }
        }
    }

    /**
     * 裏返す
     *
     * @param b_or_w
     * @param xIndex
     * @param yIndex
     * @param xDirection
     * @param yDirection
     * @param xIndex2
     * @param yIndex2
     */
    private void reverseBoards(int b_or_w, int xIndex, int yIndex, int xDirection, int yDirection, int xIndex2, int yIndex2) {
        for (int i = xIndex + xDirection, j = yIndex + yDirection; (this.reversi.hasIndex(i, j)); i = i + xDirection, j = j + yDirection) {
            // 裏返す
            this.reversi.setBoards(i, j, b_or_w);
            // 最後まで裏返したか
            if (i == xIndex2 && j == yIndex2) {
                return;
            }
        }

    }

    private String getResultFormat(int black, int white) {
        return String.format("%02d-%02d", black, white);
    }

}

/**
 * リバーシ
 *
 * @author lifer
 *
 */
class Reversi {
    // 盤上マス二次元配列 8x8初期化(white:1 / black;-1 / 配置無し:0)
    private int boards[][] = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, -1, 0, 0, 0 }, { 0, 0, 0, -1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

    public Reversi() {
    }

    public boolean isBlack(int xIndex, int yIndex) {
        return (this.boards[xIndex][yIndex] == -1);
    }

    public boolean isWhite(int xIndex, int yIndex) {
        return (this.boards[xIndex][yIndex] == 1);
    }

    public boolean isSame(int xIndex, int yIndex, int value) {
        return (this.boards[xIndex][yIndex] == value);
    }

    public void setBoards(int xIndex, int yIndex, int value) {
        this.boards[xIndex][yIndex] = value;

        // TODO:CommentOut
        // System.out.print(String.format(", %s %d %d", value == 1 ? "W" : "B",
        // xIndex + 1, yIndex + 1));
    }

    public boolean hasIndex(int xIndex, int yIndex) {
        if ((0 <= xIndex) && (xIndex <= 7) && (0 <= yIndex) && (yIndex <= 7)) {
            return true;
        }
        return false;
    }
}