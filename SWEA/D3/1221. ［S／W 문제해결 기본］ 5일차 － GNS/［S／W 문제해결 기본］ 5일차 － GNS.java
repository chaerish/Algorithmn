
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    private static HashMap<String,Integer> numbers = new HashMap<>();
	private static List<String> strArr = Arrays.asList(
			"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
			);
	static {
		numbers.put("ZRO",0);
		numbers.put("ONE",1);
		numbers.put("TWO",2);
		numbers.put("THR",3);
		numbers.put("FOR",4);
		numbers.put("FIV",5);
		numbers.put("SIX",6);
		numbers.put("SVN",7);
		numbers.put("EGT",8);
		numbers.put("NIN",9);		
		
	}
	public static void main(String [] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String prefix = st.nextToken();
        	int len = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	int [] check = new int[10];
        	for(int i=0; i<len; i++) {
        		int idx = numbers.get(st.nextToken());
        		check[idx] ++;
        	}
        	sb.append(prefix).append("\n");
        	for(int i = 0; i<10; i++) {
        		for(int j=0; j<check[i]; j++) {
        			sb.append(strArr.get(i)).append(" ");
        		}
        	}
        	sb.append("\n");
        }
        System.out.println(sb);       
	}
}