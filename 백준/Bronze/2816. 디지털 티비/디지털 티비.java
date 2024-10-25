import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main {
	private static String [] channel;
	private static final String KBS1 = "KBS1";
	private static final String KBS2 = "KBS2";
	private static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		/*
		1->화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
		2->화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
		3->현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
		4->현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)
		 */
		channel = new String [N];
		for(int i =0; i<N; i++) {
			channel[i] = br.readLine();
		}
		for(int i = 0; i< N ; i++) {
			if(channel[i].equals(KBS1)) {
				String tmp ="";
				for(int j = i; j>0; j--) {	
					System.out.print("4");
					tmp = channel[j-1];
					channel[j-1] = channel[j];
					channel[j]=tmp;
				}
				break;
			} 
			System.out.print("1"); //KBS1을 찾을 때까지 1을 출력 
		}
		if(channel[1].equals(KBS2)) { //만약 옮기는 과정에서 KBS2가 두번째에 있다면 
			return;		
		}
		for(int i = 0; i< N ; i++) {
			if(channel[i].equals(KBS2)) {
				for(int j = i; j>1; j--) { //j가 1보다 클때만
					System.out.print("4");
					String tmp = channel[j-1];
					channel[j-1] = channel[j];
					channel[j] = tmp;
				}
				break;
			}
			System.out.print("1"); //KBS2을 찾을 때까지 1을 출력 
		}
		
		
		
	}	
	
	
	public static void main(String[]args) throws IOException {
		Main.solution();
	}

}