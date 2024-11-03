import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int si = Integer.parseInt(st.nextToken());
		int bun = Integer.parseInt(st.nextToken());
		
		int hap = si*60 + bun - 45;
		if(hap<0) {
			hap+=24*60; //24시간을 더해준다.
		}
		si = hap / 60 ;
		bun = hap % 60;
		System.out.println(si+ " "+bun);
		
	}

}
