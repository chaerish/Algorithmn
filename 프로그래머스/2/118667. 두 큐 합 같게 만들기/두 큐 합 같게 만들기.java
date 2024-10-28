import java.util.Arrays;
class Solution {
    public int solution(int [] queue1, int []queue2) {
		int answer = 0;
		int n = queue1.length;
		
		//하나의 배열로 두개의 큐를 합친다.
		long [] merged = new long[n*2];
		for(int i =0; i<n; i++) {
			merged[i] = queue1[i];
		}
		for(int i =0; i<n; i++) {
			merged[i+n] = queue2[i];
		}
		//각 큐의 합 계산
		long q1sum = Arrays.stream(queue1).sum();
		long q2sum = Arrays.stream(queue2).sum();
		//모든 원소 합이 홀수인경우 종료
		if((q1sum+q2sum)%2!=0){
			return -1;
		}
		long target = (q1sum+q2sum) / 2; //구해야 하는 목표 sum
		//queue1의 왼,오포인터
		int l1=0; //처음 
		int r1=n-1; //마지막
		//queue2의 왼,오 포인터
		int l2 = n;
		int r2 = 2*n-1;
		
		//배열의 구간을 모두 탐색한 후 종
		//배열의 길이는 2n으로 한 번의 연산은 두 포인터를 이동하므로 최악의 탐색은 4n
		while(answer<4*n) { //answer이  4n보다 작을때만 
			if(q1sum<target) {
				//queue1의 합이 목표 값보다 작은 경우 
				r1 = (r1+1)%merged.length;
				l2 = (l2+1)%merged.length;
				
				q1sum +=merged[r1]; //마지막 요소를 합친다.
				q2sum -=merged[r1]; //q2sum에서 뺀 요소를 뺀다.
				
				answer += 1;
			}
			if(q2sum<target) {
				//queue2의 합이 목표 값보다 작은 경우
				r2 = (r2+1)%merged.length; //r2를 증가시킨다.
				l1 = (l1+1)%merged.length; // l1을 감소시킨다.
				
				q2sum+=merged[r2];
				q1sum-=merged[r2];
				
				answer+=1;
			}
			if(q1sum == target && q2sum == target) {
				break;
			}
		}
		//다끝냈는데도 같지 않으면 -1 같으면 answer 출력 
		return q1sum == q2sum ? answer : -1; 
	}
}