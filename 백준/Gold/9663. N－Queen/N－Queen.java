import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static boolean board[][];
    static int N;
    static int [] dr = new int[] {-1,-1,-1}; 
    static int [] dc = new int[] {-1,0,1};
    static int count;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N =Integer.parseInt(br.readLine());
            board = new boolean[N][N];
            count = 0;
            recursive(0);
        System.out.println(count);
    }
    
    private static void recursive(int depth) {
        if(depth == N) {
            count++;
            return;
        }
        for(int i=0; i<N;i++) {
            if(canPlace(depth,i)) {
                board[depth][i] = true;
                recursive(depth+1); //다음으로
                board[depth][i] = false;
            }
        }
    }
    
    private static boolean canPlace(int r, int c) {
        for(int i=1; i<= r;i++) {
            for(int j=0; j<3; j++) {
                int nr = r+dr[j]*i;
                int nc = c+dc[j]*i;
                if(nc<N && nc>=0 && board[nr][nc]) {
                    return false;
                }
            }
        }
        return true;
    }
}