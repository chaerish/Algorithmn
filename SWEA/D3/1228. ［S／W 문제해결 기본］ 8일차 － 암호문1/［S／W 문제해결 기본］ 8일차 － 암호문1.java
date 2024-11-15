
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int secret [] = new int[20];
	static int change[];
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test =1; test<=10; test++) {
			int olen = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<olen; i++) {
				secret[i] = Integer.parseInt(st.nextToken());
			}
			int change = Integer.parseInt(br.readLine()); //7
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String l = st.nextToken();
				int start = Integer.parseInt(st.nextToken());
				int clen = Integer.parseInt(st.nextToken());
				int [] arr = new int [clen];
				for(int i=0; i<clen; i++) {
					arr[i]= Integer.parseInt(st.nextToken());
				}
				swap(start,arr);
			}
			sb.append("#").append(test).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(secret[i]).append(" ");
			}
			sb.append("\n");		
		}
		System.out.println(sb);	
		
	}
	private static void swap(int start, int[] arr) {
		if(start>=20) {
			return;
		}
		int len = arr.length;
		change = new int[20];
		for(int i=0; i<start; i++) {
			change[i] = secret[i];
		}
		for(int i=0; i<len; i++) {
			if(start+i>=secret.length) {
				break;
			}
			change[start+i] = arr[i];
		}
		for(int i=start; i<secret.length; i++) {
			if(i+len>=secret.length){
				break;
			}
			change[i+len] = secret[i];
		}
		secret = change;
	}
}
