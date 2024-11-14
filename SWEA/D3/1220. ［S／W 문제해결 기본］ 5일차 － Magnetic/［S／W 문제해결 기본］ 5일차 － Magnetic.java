/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	private static final int N = 100;
	private static Deque<Boolean>[]dq ;
	public static void main(String args[]) throws Exception{
		//System.setIn(new FileInputStream("/Users/vecherish/Downloads/input.txt"));
        Scanner sc = new Scanner(System.in);
        for (int test=1; test<=10; test++) {
        	String M = sc.nextLine();
        	int answer = 0;
        	dq = new ArrayDeque[100];
        	for(int i =0; i<100; i++) {
        		dq[i] = new ArrayDeque<Boolean>();
        	}
        	for(int i = 0; i<N;i++) {
        		StringTokenizer st = new StringTokenizer(sc.nextLine());
        		for(int j=0; j<N; j++) {
        			String str = st.nextToken();
                    if(str.equals("1"))
                        dq[j].offer(true); //N to S
                    else if(str.equals("2"))
                        dq[j].offer(false); //S to N
        		}
        	}
        	for(int i =0; i<100; i++) {
        		while(!dq[i].isEmpty() && !dq[i].peekFirst()) { //false  ->위로 감 
        			dq[i].pollFirst();
        		}
        		while(!dq[i].isEmpty() && dq[i].peekLast()) { //true  ->밑으로 가야됨 
        			dq[i].pollLast();
        		}
        	}   	
        	for(int i =0; i<100; i++) {
        		if(dq[i].isEmpty()) {
        			continue;
        		}
        		while(!dq[i].isEmpty()) {
        			if(!dq[i].pollFirst()) {
        				answer ++;
        				while(!dq[i].isEmpty() && !dq[i].peekFirst()) { //교착지점 
        					dq[i].pollFirst();
            			}	
        			}
        		}
        	}
        	System.out.println("#"+test+" "+answer); 	
        }
	}
}