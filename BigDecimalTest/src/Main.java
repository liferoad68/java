
/**
 * BigDecimalTest
Java使いなら、型にセンシティブになって当然よね。
Java使いなら、お金の計算の時の固定小数点数くらいはお手のものよね。

浮動小数点数の0.1は2進数では表現できないから、0.1を10回足し上げても１.0にはならないの。これは知ってるよね。

そういう時のために、BigDecimalというクラスがあるの。これがサンプル。

import java.math.*;
class CodeIQ{
public static void main(String[] args){
    BigDecimal pointOne = new BigDecimal(0.1); 
    BigDecimal sum = new BigDecimal(0);
    
      for(int i=0;i<10;i++){
      sum = sum.add(pointOne);
    }
    System.out.println("ans:"+ sum);
    }
}

これで実行すると、ans:1.0が出力されるはず！

ans:1.0000000000000000555111512312578270211815834045410156250

あれ？あれれ？あれれれれ？おっかしぃなぁ。


【問題】
Javaちゃんが書いたコードをペーストして、「ans:1.0」が出力されるように、ソースを書きなおしてください。
書き直す箇所は１行めから５行目までの１箇所のみです。
 */

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
//	    BigDecimal pointOne = new BigDecimal(0.1); 
		BigDecimal pointOne = new BigDecimal("0.1");
		BigDecimal sum = new BigDecimal(0);

		for (int i = 0; i < 10; i++) {
			sum = sum.add(pointOne);
		}
		System.out.println("ans:" + sum);
	}
}
