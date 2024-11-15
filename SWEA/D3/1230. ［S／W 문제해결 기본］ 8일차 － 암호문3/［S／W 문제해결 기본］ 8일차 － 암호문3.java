import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int MAX = 4000;
    static int secret [];
    static int changeArr[];
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int test =1; test<=10; test++) {
            int olen = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            secret = new int[MAX];
            for(int i=0; i<olen; i++) {
                secret[i] = Integer.parseInt(st.nextToken());
            }
            int change = Integer.parseInt(br.readLine()); //7
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String type = st.nextToken();
                changeArr = new int[MAX];
                if(type.equals("I")) {
                    int start = Integer.parseInt(st.nextToken());
                    int clen = Integer.parseInt(st.nextToken());
                    int [] arr = new int [clen];
                    for(int i=0; i<clen; i++) {
                        arr[i]= Integer.parseInt(st.nextToken());
                    }
                    update(start,arr);
                }else if(type.equals("D")){
                    int start = Integer.parseInt(st.nextToken());
                    int deleteNumber = Integer.parseInt(st.nextToken());
                    delete(start,deleteNumber);
                }else {
                    int clen = Integer.parseInt(st.nextToken());
                    int [] arr = new int [clen];
                    for(int i=0; i<clen; i++) {
                        arr[i]= Integer.parseInt(st.nextToken());
                    }
                    insert(arr);
                }
            }
            sb.append("#").append(test).append(" ");
            for(int i=0; i<10; i++) {
                sb.append(secret[i]).append(" ");
            }
            sb.append("\n");        
        }
        System.out.println(sb); 
         
    }
    private static void update(int start, int[] arr) {
        if(start>=MAX) {
            return;
        }
        int len = arr.length;
        for(int i=0; i<start; i++) {
            changeArr[i] = secret[i];
        }
        for(int i=0; i<len; i++) {
            if(start+i>=secret.length) {
                break;
            }
            changeArr[start+i] = arr[i];
        }
        for(int i=start; i<secret.length; i++) {
            if(i+len>=secret.length){
                break;
            }
            changeArr[i+len] = secret[i];
        }
        secret = changeArr;
    }
    private static void delete(int start, int number) {
        if(start>=MAX || number>=MAX) {
            return;
        }
        for(int i=0; i<start; i++) {
            changeArr[i] = secret[i];
        }
        for(int i=start; i<secret.length; i++) {
            if(i+number>=secret.length){
                break;
            }
            changeArr[i] = secret[i+number];
        }
        secret = changeArr;
    }
    private static void insert(int [] arr) {
        if(arr.length>=MAX) {
            return;
        }
        int start = 0;
        for(int i=0; i<MAX; i++) {
            if(secret[i]==0) {
                start = i;
                return;
            }
        }
        for(int i=0; i<arr.length; i--) {
            if(start+i>=MAX) {
                break;
            }
            arr[start+i] = arr[i];
        }
        secret = changeArr;     
    }
}