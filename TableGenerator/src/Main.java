
/**
 * B033:テーブルジェネレーター
【問題】
見出しの情報と各行の情報から見やすい表を生成するプログラムをつくりましょう。テンプレートは以下のようになります。


| header 1 | header 2    | ... | header n |  (見出し行)
|----------|-------------| ... |----------|  (区切り行)
| xx       | xxxxxxx     | ... | XX       |  (データ行)
| yyyy     | yyyyyyyyyyy | ... | YY       |  (データ行)
...                       ...
| zzz      | zzzzzzz     | ... | ZZ       |  (データ行)

[テンプレートの説明]
※ 表の作成には等幅のフォントを用います。すなわちこの表で使われる文字の文字幅はすべて等しくなります。

・表の 1 行目を見出し行、2 行目を区切り行、 3 行目以降をデータ行とよびます。
・表の各見出し・データを格納する部分は "| xxx |" のように縦棒 2 つの間に見出し・データが入り、見出し・データの前にちょうど 1 つ、後ろに 1 つ以上半角スペースが入る形にします。
・各列の幅はその列の中で最も長さの大きい見出し・データが上記の形で収まる最小の幅 (見出し・データの前後にちょうど 1 つずつ半角スペースが入れられる幅) にします。
・区切り行は縦棒を除きハイフンで埋めます。

例）
見出し: id, name
各行のデータ:
1 ito
2 sakakibara
3 takahashi

このとき生成する表は以下のようになります。

| id | name       |
|----|------------|
| 1  | ito        |
| 2  | sakakibara |
| 3  | takahashi  |

評価ポイント
10個のテストケースを入力し、正答数と解答の提出までに要した時間を測定し得点が決まります。
※制限時間を超えるとテストケースが通っても失格(0点)となります。
※提出いただいたコードは複数回実行され、一度の実行では1つのテストケースのみ入力
得点の計算方法：正解数得点(50点) ＋ 正解率×回答時間得点(40分以内で50点、80分で25点、2時間で0点と線形に点数が落ちます)
複数のテストケースで正しい出力がされるか評価（+50点）
解答までの速さ評価（+50点）
入力される値
入力は以下のフォーマットで与えられます。

W
c_1 c_2 ... c_W
H
r_{1,1} r_{1,2} ... r_{1,W}
r_{2,1} r_{2,2} ... r_{2,W}
...
r_{H,1} r_{H,2} ... r_{H,W}

・1 行目に見出しの個数を表す整数 W が与えられます。
・2 行目に、j 列目 (1 ≦ j ≦ W) の見出しを表す c_j が、c_1, c_2, ... c_W の順に半角スペース区切りで与えられます。
・3 行目にその後入力されるデータ行の行数を表す整数 H が与えられます。
・続く H 行のうちの i 行目 (1 ≦ i ≦ H) に、i 行 j 列目 (1 ≦ j ≦ W) のデータを表す文字列 r_{i, j} が r_{i,1}, r_{i,2},...,r_{i,W} の順に半角スペース区切りで与えられます。
・入力は合計で H + 3 行となり、入力値最終行の末尾に改行が１つ入ります。

文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください
期待する出力
h
s
d_1
d_2
...
d_H
・期待する出力は H + 2 行からなります。
・1 行目に問題文の条件に沿って見出し行を表す文字列 h を出力してください。
・2 行目に問題文の条件に沿って区切り行を表す文字列 s を入力してください。
・続く H 行のうちの i 行目 (1 ≦ i ≦ H) に問題文の条件に沿って i 行目のデータ行を表す文字列 d_i を出力してください。
・H + 2 行目の出力の最後に改行を入れ、余計な文字、空行を含んではいけません。
条件
すべてのテストケースで以下の条件を満たします。

・入力される文字列はすべて数字または英小文字で構成される
・1 ≦ W ≦ 100
・1 ≦ H ≦ 100
・1 ≦ (c_j の長さ) ≦ 20 (1 ≦ j ≦ W)
・1 ≦ (r_{i, j} の長さ) ≦ 20 (1 ≦ i ≦ H, 1 ≦ j ≦ W)

入力例1
2
id name
3
1 ito
2 sakakibara
3 takahashi
出力例1
| id | name       |
|----|------------|
| 1  | ito        |
| 2  | sakakibara |
| 3  | takahashi  |
入力例2
6
name english math japanese science socialstudies
7
aoyama 70 82 66 79 90
okada 44 65 57 69 88
koyama 52 47 61 23 71
takeda 48 58 80 34 93
nakano 55 39 62 77 80
miura 23 40 35 46 53
yagami 91 92 95 90 100
出力例2
| name   | english | math | japanese | science | socialstudies |
|--------|---------|------|----------|---------|---------------|
| aoyama | 70      | 82   | 66       | 79      | 90            |
| okada  | 44      | 65   | 57       | 69      | 88            |
| koyama | 52      | 47   | 61       | 23      | 71            |
| takeda | 48      | 58   | 80       | 34      | 93            |
| nakano | 55      | 39   | 62       | 77      | 80            |
| miura  | 23      | 40   | 35       | 46      | 53            |
| yagami | 91      | 92   | 95       | 90      | 100           |

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 見出し入力
        List<String> titles = new ArrayList<String>();
        int w = Integer.valueOf(br.readLine().trim());
        String[] titleStrings = br.readLine().trim().split(" ");
        for (int i = 0; i < w; i++) {
            titles.add(titleStrings[i]);
        }

        // データ入力
        List<List<String>> dataLists = new ArrayList<List<String>>();
        int h = Integer.valueOf(br.readLine().trim());
        for (int j = 0; j < h; j++) {
            String[] dataStrings = br.readLine().trim().split(" ");
            List<String> datas = new ArrayList<String>();
            for (String data : dataStrings) {
                datas.add(data);
            }
            dataLists.add(datas);
        }

        // 出力
        TableGenerator tg = new TableGenerator(titles, dataLists);
        tg.systemOutPrint();

    }
}

class TableGenerator {

    private final String DELIMITER = "|";
    private final String TITLE_DELIMITER = "-";

    private List<String> titles = null;
    private List<List<String>> dataLists = null;

    /**
     * コンストラクタ
     * @param titles
     * @param dataLists
     */
    public TableGenerator(List<String> titles, List<List<String>> dataLists) {
        this.titles = titles;
        this.dataLists = dataLists;
    }

    /**
     * 出力
     */
    public void systemOutPrint() {

        List<Integer> maxLengthList = createMaxLengthList();

        systemOutPrintTitle(maxLengthList);
        systemOutPrintTitleDelimiter(maxLengthList);
        systemOutPrintData(maxLengthList);
    }

    /**
     * 見出し出力
     * @param maxLengthList
     */
    private void systemOutPrintTitle(List<Integer> maxLengthList) {
        StringBuilder sbTitles = new StringBuilder();
        for (int i = 0; i < this.titles.size(); i++) {
            String fillSpaceFormat =getFillSpaceFormat(maxLengthList.get(i));
            sbTitles.append(DELIMITER);
            sbTitles.append(" ");
            sbTitles.append(String.format(fillSpaceFormat, this.titles.get(i)));
            sbTitles.append(" ");
        }
        sbTitles.append(DELIMITER);
        System.out.println(sbTitles.toString());
    }

    /**
     * 見出し区切り出力
     * @param maxLengthList
     */
    private void systemOutPrintTitleDelimiter(List<Integer> maxLengthList) {
        StringBuilder sbDelimiter = new StringBuilder();
        for (int i = 0; i < this.titles.size(); i++) {
            sbDelimiter.append(DELIMITER);
            for (int j = 0; j <= maxLengthList.get(i) + 1; j++) {
                sbDelimiter.append(TITLE_DELIMITER);
            }
        }
        sbDelimiter.append("|");
        System.out.println(sbDelimiter.toString());
    }

    /**
     * データ出力
     */
    public void systemOutPrintData(List<Integer> maxLengthList) {
        for (int i = 0; i < this.dataLists.size(); i++) {
            StringBuilder sbData = new StringBuilder();
            for (int j = 0; j < this.dataLists.get(i).size(); j++) {
                String fillSpaceFormat =getFillSpaceFormat(maxLengthList.get(j));
                sbData.append(DELIMITER);
                sbData.append(" ");
                sbData.append(String.format(fillSpaceFormat, this.dataLists.get(i).get(j)));
                sbData.append(" ");
            }
            sbData.append(DELIMITER);
            System.out.println(sbData.toString());
        }
    }

    /**
     * スペース埋めフォーマット取得
     * @param fillSpaceLength
     * @return
     */
    private String getFillSpaceFormat(int fillSpaceLength) {
        return "%-" + String.format("%d", fillSpaceLength) + "s";
    }

    /**
     * 最大長リスト生成
     * @return
     */
    private List<Integer> createMaxLengthList() {
        List<Integer> maxLengthList = new ArrayList<Integer>();
        for (int i = 0; i < this.titles.size(); i++) {
            int maxLength = this.titles.get(i).length();
            for (int j = 0; j < this.dataLists.size(); j++) {
                int dataLength = this.dataLists.get(j).get(i).length();
                if (maxLength < dataLength) {
                    maxLength = dataLength;
                }
            }
            maxLengthList.add(maxLength);
        }
        return maxLengthList;
    }
}
