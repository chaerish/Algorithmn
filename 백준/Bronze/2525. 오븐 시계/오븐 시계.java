import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a =  Integer.parseInt(st.nextToken());
		int b =  Integer.parseInt(st.nextToken());
		int c =  Integer.parseInt(br.readLine());
		
		int s = a+((b+c)/60); //몫 = 시에 더함
		int m = (b+c)%60; //분
		if(s >= 24) {
			s =s%24;
		}
		
		System.out.print(s+" "+m);
		
							
	}

}