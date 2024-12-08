import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int flag;
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			flag = 0;
			String str= br.readLine();
			boolean isPalin = check(str);
			if(!isPalin && flag == 2) {
				sb.append(flag).append("\n");
			}else if(isPalin && flag ==1) {
				sb.append(flag).append("\n");
			}else if(isPalin && flag ==0) {
				sb.append(flag).append("\n");
			}
		}
		System.out.println(sb);
	}
	private static boolean check(String str) {
		int l = 0;
		int r = str.length() - 1;
		while(l<r) {
			if(str.charAt(l) != str.charAt(r)) {
				String skipLeftStr = getString(str,l);
				String skipRightStr = getString(str,r);
				boolean skipLeft = isPalindrome(skipLeftStr,0, skipLeftStr.length()-1);
				boolean skipRight = isPalindrome(skipRightStr,0, skipLeftStr.length()-1);
				if(skipLeft || skipRight) {
					flag = 1;
					return true;
				}else {
					flag = 2;
					return false;
				}
			}
			l ++ ;
			r -- ;
		}
		return true;	
	}
	private static boolean isPalindrome(String str, int l, int r) {
		while(l<r) {
			if(str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	private static String getString(String str,int index) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length();i++) {
			if(i == index) {
				continue;
			}
			sb.append(str.charAt(i));
		}
		return sb.toString();	
	}
}
