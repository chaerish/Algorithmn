import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{
    private static int [] buildings;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 0;
		while (T++ < 10) {
			buildings = new int[Integer.parseInt(br.readLine())];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0; i<buildings.length; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			int answer = 0;
			for(int i = 2; i<buildings.length -2; i++) {
				 int max =  Math.max(Math.max(buildings[i-2], buildings[i-1]),Math.max(buildings[i+2], buildings[i+1]));
				 answer += Math.max(0, buildings[i]-max); 
			}
			sb.append("#"+T+" ").append(answer).append("\n");  
		}
		System.out.println(sb);
	}

}