import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    static HashMap<String,SunBae> memo = new HashMap<>();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String name =st.nextToken();
            SunBae sunBae = new SunBae(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            memo.put(name,sunBae);
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int money = Integer.parseInt(st.nextToken());
            if(!memo.get(name).isAvaliable(money)){
                memo.remove(name);
            }
        }
        boolean[][] visit = new boolean[11][7];
        for(String s:memo.keySet()){
            visit[memo.get(s).week][memo.get(s).day] = true;
        }
        int max = 0;
        int count = 0;

        for(int i = 1; i<11;i++){
            for(int j=0; j<7; j++){
                if(visit[i][j]){
                    count++;
                }else if(count!=0){
                    max = Math.max(max,count);
                    count = 0;
                }
            }
        }
        max = Math.max(max,count);
        System.out.println(max);


    }
    public static class SunBae{
        int week;
        int day;
        int payMoney;
        public boolean isAvaliable(int money){
            return money >= payMoney;
        }
        public SunBae(int week, int day, int payMoney) {
            this.week = week;
            this.day = day;
            this.payMoney = payMoney;
        }
    }
}


