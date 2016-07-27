import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main2 {

	private static Map<Integer, Integer> sosuList = new HashMap<Integer, Integer>();

	public static void main2(String[] args) {
		Scanner cin = new Scanner(System.in);
		String line;
		for (; cin.hasNext();) {
			line = cin.nextLine();
			System.out.println(sosuCount(line));
		}
		cin.close();
	}

	public static String sosuCount(String str) {
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return "0";
		}

		int iSosuCount = 0;
		for (int i = num - 1; i >= 2; i--) {
			
			if (isSosuCalc(i)) {
				iSosuCount++;
			}
			if(sosuList.containsKey(new Integer(i))){
				iSosuCount = iSosuCount + sosuList.get(new Integer(i));
				break;
			}
		}
		sosuList.put(new Integer(num), new Integer(iSosuCount));
		return String.valueOf(iSosuCount);
	}

	public static boolean isSosuCalc(int n) {
		if (n == 2) {
			return true;
		}
		if ((n % 2) == 0) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if ((n % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
