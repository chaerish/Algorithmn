import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static TreeMap<String,Integer> map = new TreeMap<>();
    static double M = 100.0;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str ="";
        while((str = br.readLine())!=null){
            if(map.containsKey(str)) {
                int value = map.get(str);
                map.put(str, value+1);
            }else {
                map.put(str,1);
            }
        }
        int size = 0;
        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            size+=entry.getValue();
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            double value = (entry.getValue()* M )/ size ;
            String d = String.format("%.4f",value);
            sb.append(entry.getKey()).append(" ").append(d).append("\n");
        }
        System.out.println(sb);
    }

}