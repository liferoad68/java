
/**
 * xxxx:XXXX
【問題】
XXXXX

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(getDefaultMethod(br.readLine().trim()));
	}

	public static int getDefaultMethod(String line) {
		int max = 0;
		String[] lineStrings = line.split(" ");
		for (int i = 0; i < lineStrings.length; i++) {
			max = calculateMethod(max, lineStrings[i]);
		}
		return max;
	}

	public static int calculateMethod(int max, String str) {
		int n = Integer.valueOf(str);
		if (max < n) {
			return n;
		}
		return max;

	}
}