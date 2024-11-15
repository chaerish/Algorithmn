import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class Solution {
	static char [] secret;
	static int [] secretInt;
	static HashMap<String,Integer> hash = new HashMap<>();
	static {
		hash.put("0001101",0);
		hash.put("0011001",1);
		hash.put("0111101", 3);
		hash.put("0100011", 4);
		hash.put("0010011",2 );
		hash.put("0110001",5);
		hash.put("0101111", 6);
		hash.put("0111011",7);
		hash.put("0110111", 8);
		hash.put("0001011", 9);	
	}
	
	public static void main(String [] args) throws Exception {
		//System.setIn(new FileInputStream("/Users/vecherish/Downloads/input (3).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int len = Integer.parseInt(br.readLine());
		for(int test =1; test<=len; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N =  Integer.parseInt(st.nextToken()); 
			int M =  Integer.parseInt(st.nextToken()); 
			String secretStr = "";
			for(int i = 0 ; i<N; i++) {
				String str = br.readLine();
				if(str.contains("1")) {
					secret = str.toCharArray();
					secretStr = str;
				}
			}
			int end = 0;
			for(int i=secret.length-1; i>=0; i--) { //가장 첫번째 1을 찾으면 해당 인덱스를 리턴한다.
				if(secret[i] == '1') {
					end = i;
					break;
				}
			}
			secretInt = new int[8];
			for(int i =0 ; i< 8 ; i++) { 
				end = end -7;
				String split = secretStr.substring(end+1,end+8);
				int strInt = hash.get(split);
				if(strInt>=0) {
					secretInt[7-i] = strInt;
				}
			}
			int oddSum = 0;
			int evSum =0;
			for(int i=0; i<8; i++) {
				if((i+1)%2 ==0) {
					evSum+=secretInt[i];
				}else {
					oddSum+=secretInt[i];
				}
			}
			int result = 0;
			if((oddSum*3+evSum)%10 == 0) {
				result = oddSum+evSum;
			}
			sb.append("#").append(test).append(" ").append(result).append("\n");				
		}
		System.out.println(sb);
	}
}
