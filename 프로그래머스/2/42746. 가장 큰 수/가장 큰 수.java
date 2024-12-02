import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int num: numbers){
            list.add(String.valueOf(num));     		
        }
        Collections.sort(list,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder result = new StringBuilder();
        for(String str: list) {
            result.append(str);
        }
        if(result.charAt(0) == '0'){
            return "0";
        }
        return result.toString();
    }
	    
}